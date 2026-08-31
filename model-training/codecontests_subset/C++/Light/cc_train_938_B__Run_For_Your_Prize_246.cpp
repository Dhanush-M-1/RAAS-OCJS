#include <bits/stdc++.h>
using namespace std;
int n, arr[1000001];
int main() {
  cin >> n;
  int tem;
  for (int i = 0; i < n; i++) {
    cin >> tem;
    arr[tem] = 1;
  }
  int i_f = 0, j_f = 0;
  for (int i = 500000, j = i + 1;; i--, j++) {
    if (arr[i] == 1 && i_f == 0) {
      i_f = i;
    }
    if (arr[j] == 1 && j_f == 0) {
      j_f = j;
    }
    if (i_f && j_f) break;
  }
  printf("%d", max(i_f - 1, 1000000 - j_f));
}
