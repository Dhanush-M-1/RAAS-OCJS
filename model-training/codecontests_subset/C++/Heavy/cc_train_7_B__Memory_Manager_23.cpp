#include <bits/stdc++.h>
using namespace std;
struct node {
  int n;
  int l;
  int r;
  int size;
  node() {}
  node(int a, int b, int c, int d, node *ne, node *pre)
      : n(a), l(b), r(c), size(d), next(ne), prev(pre) {}
  node *next;
  node *prev;
};
int toINT(char an[], int s) {
  int total = 0;
  for (int i = s; an[i] != '\0'; i++) total = total * 10 + an[i] - '0';
  return total;
}
node *alloc = NULL, *space, *temp;
char command[100];
int t, m, counts = 1;
void deletes(node *head, node *del, bool flag) {
  if (del == head) {
    if (flag == 0) space = del->next;
    if (flag == 1) alloc = del->next;
    if (del->next != NULL) del->next->prev = NULL;
  } else {
    del->prev->next = del->next;
    if (del->next != NULL) del->next->prev = del->prev;
  }
  delete del;
}
void insert(node *head, node *in, bool flag) {
  if (head == NULL) {
    if (flag == 1) alloc = in;
    if (flag == 0) space = in;
    in->next = NULL;
    return;
  }
  while (head->next != NULL) {
    if (head->l > in->l) break;
    head = head->next;
  }
  if (head->l > in->l) {
    if (flag == 0) {
      if (head->prev != NULL && head->prev->r + 1 == in->l) {
        head->prev->r = in->r;
        head->prev->size += in->size;
        if (head->prev->r + 1 == head->l) {
          head->prev->r = head->r;
          head->prev->size += head->size;
          deletes(space, head, 0);
        }
        return;
      }
      if (in->r + 1 == head->l) {
        head->l = in->l;
        head->size += in->size;
        return;
      }
    }
    in->next = head;
    in->prev = head->prev;
    if (head->prev != NULL)
      head->prev->next = in;
    else {
      if (flag == 1) alloc = in;
      if (flag == 0) space = in;
    }
    head->prev = in;
  } else {
    if (flag == 0 && in->l == head->r + 1) {
      head->r = in->r, head->size += in->size;
      return;
    }
    head->next = in;
    in->prev = head;
    in->next = NULL;
  }
}
int main() {
  scanf("%d %d\n", &t, &m);
  space = new node(-1, 1, m, m, NULL, NULL);
  for (int i = 0; i < t; i++) {
    gets(command);
    if (strncmp(command, "alloc", 5) == 0) {
      temp = space;
      int v = toINT(command, 6);
      while (temp != NULL) {
        if (temp->size >= v) break;
        temp = temp->next;
      }
      if (temp == NULL)
        printf("NULL\n");
      else if (temp->size == v) {
        node *al = new node(*temp);
        printf("%d\n", counts);
        al->n = counts++;
        deletes(space, temp, 0);
        insert(alloc, al, 1);
      } else {
        node *al = new node(*temp);
        printf("%d\n", counts);
        al->n = counts++;
        al->r = al->l + v - 1;
        al->size = v;
        insert(alloc, al, 1);
        temp->l += v, temp->size = temp->r - temp->l + 1;
      }
    }
    if (strncmp(command, "erase", 5) == 0) {
      temp = alloc;
      int v = toINT(command, 6);
      while (temp != NULL) {
        if (temp->n == v) break;
        temp = temp->next;
      }
      if (temp == NULL)
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else {
        node *sp = new node(*temp);
        deletes(alloc, temp, 1);
        insert(space, sp, 0);
      }
    }
    if (strncmp(command, "defragment", 10) == 0) {
      int to = 0;
      temp = alloc;
      while (temp != NULL) {
        temp->l = 1 + to;
        temp->r = 1 + to + temp->size - 1;
        to += temp->size;
        temp = temp->next;
      }
      if (to != 0) space = new node(-1, to + 1, m, m - to, NULL, NULL);
    }
  }
  return 0;
}
