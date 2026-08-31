#include <bits/stdc++.h>
using namespace std;
int cnt, M;
bool arr[1000];
int pos[1000], num[1000];
void doAlloc() {
  int n;
  cin >> n;
  bool found = false;
  for (int i = 0; i + n <= M; i++) {
    bool flag = true;
    for (int j = 0; j < n; j++)
      if (!arr[i + j]) flag = false;
    if (flag) {
      ++cnt;
      pos[cnt] = i;
      cout << cnt << "\n";
      found = true;
      num[cnt] = n;
      for (int j = 0; j < n; j++) arr[i + j] = false;
      break;
    }
  }
  if (!found) cout << "NULL\n";
  return;
}
void doErase() {
  int x;
  cin >> x;
  if (x > cnt || x <= 0) {
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
    return;
  }
  int t = pos[x];
  if (x > cnt || t == -1) {
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
    return;
  }
  bool found = false;
  for (int i = 0; i < num[x]; i++)
    if (arr[i + t])
      found = true;
    else
      arr[i + t] = true;
  if (found)
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
  else
    pos[x] = num[x] = -1;
  return;
}
void doFrament() {
  int last = 0;
  for (int i = 1; i <= cnt; i++) {
    int t = pos[i], n = num[i], p;
    if (t == -1) continue;
    p = t;
    for (int j = last; j < t; j++)
      if (arr[j]) {
        p = j;
        break;
      }
    int x = t + n - 1;
    for (int j = 0; j < n; j++) arr[p + j] = false;
    for (int j = p + n; j <= x; j++) arr[j] = true;
    pos[i] = p;
    last = p + n;
  }
  return;
}
int main() {
  int T;
  cin >> T >> M;
  memset(arr, true, sizeof(arr));
  for (int i = 0; i < T; i++) {
    string command;
    cin >> command;
    if (command == "alloc")
      doAlloc();
    else if (command == "erase")
      doErase();
    else
      doFrament();
  }
  return 0;
}
