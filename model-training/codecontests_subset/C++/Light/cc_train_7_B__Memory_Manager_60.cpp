#include <bits/stdc++.h>
using namespace std;
int t, m;
int mem[100];
int cur = 1;
bool ans[105];
bool check(int b, int e) {
  for (int i = b; i < e; ++i) {
    if (mem[i]) {
      return false;
    }
  }
  return true;
}
void def() {
  queue<int> q;
  for (int i = 0; i < m; ++i) {
    if (mem[i]) {
      q.push(mem[i]);
      mem[i] = 0;
    }
  }
  for (int i = 0; !q.empty(); ++i) {
    mem[i] = q.front();
    q.pop();
  }
}
void er(int num) {
  if (num <= 0 || num > 104) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  if (!ans[num]) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  for (int i = 0; i < m; ++i) {
    if (mem[i] == num) {
      mem[i] = 0;
    }
  }
  ans[num] = false;
}
void all(int num) {
  for (int i = 0; i + num <= m;) {
    if (mem[i]) {
      i++;
      continue;
    }
    if (check(i, i + num)) {
      printf("%d\n", cur);
      ans[cur] = true;
      for (int j = i; j < i + num; ++j) {
        mem[j] = cur;
      }
      cur++;
      return;
    } else {
      i++;
    }
  }
  printf("NULL\n");
}
int main(int argc, char *argv[]) {
  memset(mem, 0, sizeof(mem));
  memset(ans, false, sizeof(ans));
  scanf("%d%d", &t, &m);
  while (t--) {
    char ch[20];
    scanf("%s", &ch);
    if (ch[0] == 'a') {
      int n;
      scanf("%d", &n);
      all(n);
    } else if (ch[0] == 'e') {
      int n;
      scanf("%d", &n);
      er(n);
    } else {
      def();
    }
  }
  return 0;
}
