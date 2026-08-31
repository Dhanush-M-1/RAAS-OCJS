#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int N, M;
  cin >> N >> M;
  vector<int> a(M, 0);
  int cnt = 1;
  while (N--) {
    string s;
    cin >> s;
    if (s[0] == 'a') {
      int n;
      cin >> n;
      int fr = 0, j = 0;
      bool flag = true;
      for (int i = 0; i < M; i++) {
        if (!a[i]) {
          if (flag) {
            j = i;
            flag = false;
          }
          fr++;
        } else {
          if (fr >= n) {
            break;
          }
          fr = 0;
          flag = true;
        }
      }
      if (fr >= n) {
        for (int i = j; i < (j + n); i++) {
          a[i] = cnt;
        }
        cout << cnt << '\n';
        cnt++;
      } else {
        cout << "NULL" << '\n';
      }
    } else if (s[0] == 'e') {
      int n;
      cin >> n;
      bool flag = false;
      for (int i = 0; i < M; i++) {
        if (a[i] == n) {
          a[i] = 0;
          flag = true;
        }
      }
      if (!n || !flag) cout << "ILLEGAL_ERASE_ARGUMENT" << '\n';
    } else {
      vector<int> b;
      for (int i = 0; i < M; i++) {
        if (a[i]) b.push_back(a[i]);
      }
      b.resize(M);
      a = b;
    }
  }
}
