/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* partition(struct ListNode* head, int x) {
    struct ListNode* smallerHead = NULL, *smallerLast = NULL;
    struct ListNode* greaterHead = NULL, *greaterLast = NULL;

    struct ListNode* current = head;
    struct ListNode* smallerCurrent = NULL, *greaterCurrent = NULL;

    while (current != NULL) {
        if (current->val < x) {
            if (smallerHead == NULL) {
                smallerHead = current;
                smallerCurrent = current;
            } else {
                smallerCurrent->next = current;
                smallerCurrent = current;
            }
        } else {
            if (greaterHead == NULL) {
                greaterHead = current;
                greaterCurrent = current;
            } else {
                greaterCurrent->next = current;
                greaterCurrent = current;
            }
        }

        current = current->next;
    }

    if (smallerHead == NULL) {
        return greaterHead;
    }

    if (greaterHead != NULL) {
        greaterCurrent->next = NULL;
    }

    smallerCurrent->next = greaterHead;

    return smallerHead;
}
