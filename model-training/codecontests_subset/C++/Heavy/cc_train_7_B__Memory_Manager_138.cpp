#include <bits/stdc++.h>
using namespace std;
int cnt, M;
bool arr[1000];
int pos[1000], num[1000], loc[1000];
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
      loc[i] = cnt;
      for (int j = 0; j < n; j++) arr[i + j] = false;
      break;
    }
  }
  if (!found) cout << "NULL\n";
  return;
}
void doErase() {
  long long x;
  cin >> x;
  if (x > cnt || x <= 0 || x > 100) {
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
    return;
  }
  int t = pos[x];
  if (t == -1) {
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
  bool found = true;
  while (found) {
    found = false;
    for (int i = 1; i < M; i++)
      if (arr[i - 1] && !arr[i]) {
        found = true;
        arr[i - 1] = false;
        arr[i] = true;
        if (loc[i] > 0) {
          loc[i - 1] = loc[i];
          pos[loc[i]] = i - 1;
          loc[i] = 0;
        }
      }
  }
  return;
}
int main() {
  int T;
  cin >> T >> M;
  cnt = 0;
  memset(arr, true, sizeof(arr));
  memset(pos, -1, sizeof(pos));
  memset(num, 0, sizeof(num));
  memset(loc, 0, sizeof(loc));
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
