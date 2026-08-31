#include <bits/stdc++.h>
#pragma GCC target("popcnt")
using namespace std;
int a[1003], b[1003];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    int N, M, temp;
    cin >> N >> M;
    set<int> a;
    for (int i = 0; i < N; ++i) {
      cin >> temp;
      a.insert(temp);
    }
    for (int i = 0; i < M; ++i) {
      cin >> b[i];
    }
    int ans = -1;
    for (int i = 0; i < M; ++i) {
      if (a.find(b[i]) != a.end()) {
        ans = b[i];
        break;
      }
    }
    if (ans == -1) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl << "1 " << ans << endl;
    }
  }
}
