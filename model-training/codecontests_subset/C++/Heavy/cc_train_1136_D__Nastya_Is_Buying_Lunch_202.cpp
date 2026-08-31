#include <bits/stdc++.h>
using namespace std;
const int maxn = 5e5 + 100;
int a[maxn];
map<pair<int, int>, bool> mp;
int main() {
  ios::sync_with_stdio(false);
  int N;
  cin >> N;
  int M;
  cin >> M;
  for (int i = 1; i <= N; i++) cin >> a[i];
  for (int i = 1; i <= M; i++) {
    int x;
    int y;
    cin >> x >> y;
    mp[pair<int, int>(x, y)] = 1;
  }
  int pos = N;
  for (int i = N - 1; i >= 1; i--) {
    if (mp[pair<int, int>(a[i], a[pos])] == true) {
      int j;
      for (j = i; j < pos; j++) {
        if (mp[pair<int, int>(a[j], a[j + 1])])
          swap(a[j], a[j + 1]);
        else
          break;
      }
      if (j == pos) pos -= 1;
    }
  }
  cout << N - pos;
}
