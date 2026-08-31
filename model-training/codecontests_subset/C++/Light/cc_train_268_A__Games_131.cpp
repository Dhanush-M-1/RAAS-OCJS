#include <bits/stdc++.h>
using namespace std;
int n, x;
pair<int, int> a[35];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i].first >> a[i].second;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (a[i].first == a[j].second) {
        x++;
      }
    }
  }
  cout << x;
}
