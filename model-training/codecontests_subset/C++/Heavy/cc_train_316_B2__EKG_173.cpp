#include <bits/stdc++.h>
using namespace std;
const int max_a = 1002;
int n, x;
int a[max_a];
int b[max_a];
int b_len = 0;
int visited[max_a] = {0};
int root[max_a] = {0};
bool count_offset = false;
int offset = 0;
void visit(int k, int w) {
  visited[k] = true;
  if (count_offset) offset++;
  if (k == x) count_offset = true;
  if (a[k] == -1) {
    if (!count_offset) {
      b[b_len] = w;
      b_len++;
    }
  } else {
    visit(a[k], w + 1);
  }
}
bool answer[max_a][max_a];
int main() {
  cin >> n >> x;
  x--;
  for (int i = 0; i < n; i++) root[i] = 1;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    a[i]--;
    if (a[i] != -1) {
      root[a[i]] = 0;
    }
  }
  for (int i = 0; i < n; i++) {
    count_offset = false;
    if (!visited[i] && root[i]) {
      visit(i, 1);
    }
  }
  if (b_len == 0) {
    printf("%d\n", offset + 1);
    return 0;
  }
  for (int i = 0; i <= b_len; i++) answer[0][i] = 1;
  for (int i = 0; i <= n; i++)
    for (int j = 1; j <= b_len; j++) {
      answer[i][j] = answer[i][j - 1];
      if (i >= b[j - 1])
        answer[i][j] = answer[i][j] || answer[i - b[j - 1]][j - 1];
    }
  for (int i = 0; i <= n; i++) {
    if (answer[i][b_len]) printf("%d\n", i + offset + 1);
  }
  return 0;
}
