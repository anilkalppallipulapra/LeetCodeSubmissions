/*
 * @lc app=leetcode id=23 lang=c
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// Min-heap node wrapper
struct HeapNode {
    struct ListNode* node;
};
void swap(struct HeapNode* a, struct HeapNode* b) {
    struct HeapNode tmp = *a;
    *a = *b;
    *b = tmp;
}
void heapifyDown(struct HeapNode heap[], int size, int i) {
    int smallest = i;
    int l = 2*i + 1, r = 2*i + 2;
    if (l < size && heap[l].node->val < heap[smallest].node->val) smallest = l;
    if (r < size && heap[r].node->val < heap[smallest].node->val) smallest = r;
    if (smallest != i) {
        swap(&heap[i], &heap[smallest]);
        heapifyDown(heap, size, smallest);
    }
}

void heapifyUp(struct HeapNode heap[], int i) {
    while (i > 0) {
        int parent = (i-1)/2;
        if (heap[i].node->val < heap[parent].node->val) {
            swap(&heap[i], &heap[parent]);
            i = parent;
        } else break;
    }
}
struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if (listsSize == 0) return NULL;

    struct HeapNode* heap = (struct HeapNode*)malloc(sizeof(struct HeapNode) * listsSize);
    int size = 0;

    // Initialize heap
    for (int i = 0; i < listsSize; i++) {
        if (lists[i]) {
            heap[size++].node = lists[i];
            heapifyUp(heap, size-1);
        }
    }

    struct ListNode dummy;
    struct ListNode* tail = &dummy;
    dummy.next = NULL;

    while (size > 0) {
        // Extract min
        struct ListNode* minNode = heap[0].node;
        tail->next = minNode;
        tail = tail->next;

        if (minNode->next) {
            heap[0].node = minNode->next;
        } else {
            heap[0] = heap[size-1];
            size--;
        }
        heapifyDown(heap, size, 0);
    }

    free(heap);
    return dummy.next;
}
// @lc code=end

