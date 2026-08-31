#include <bits/stdc++.h>
using namespace std;
void func() {
  int n;
  cin >> n;
  vector<int> arr(n), acop(n);
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
    acop[i] = arr[i];
  }
  sort(acop.begin(), acop.end(), greater<int>());
  int q;
  cin >> q;
  for (int i = 0; i < q; ++i) {
    int k, pos, cnt = 0;
    cin >> k >> pos;
    for (int i = 0; i < n; ++i) {
      if (arr[i] > acop[k - 1]) {
        ++cnt;
      }
    }
    int cnt1 = k - cnt;
    cnt = 0;
    for (int i = 0; i < n; ++i) {
      if (arr[i] >= acop[k - 1]) {
        if (arr[i] > acop[k - 1]) {
          ++cnt;
        } else if (cnt1 > 0 && arr[i] == acop[k - 1]) {
          ++cnt;
          --cnt1;
        }
        if (cnt == pos) {
          cout << arr[i] << "\n";
          break;
        }
      }
    }
  }
}
int main() {
  int t = 1;
  int cnt = 0;
  while (t--) {
    func();
  }
  return 0;
}
