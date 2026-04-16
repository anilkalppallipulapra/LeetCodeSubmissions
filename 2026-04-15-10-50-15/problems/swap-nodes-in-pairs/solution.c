/*
 * @lc app=leetcode id=24 lang=c
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode* prev = &dummy;

    while (prev->next && prev->next->next) {
        struct ListNode* first = prev->next;
        struct ListNode* second = first->next;

        // Swap
        first->next = second->next;
        second->next = first;
        prev->next = second;

        // Move prev forward
        prev = first;
    }
    return dummy.next;
}
// @lc code=end

