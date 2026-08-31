#include <bits/stdc++.h>
using namespace std;
int n;
int x = 1;
int ans;
int a, b;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  vector<int> vc1(n);
  vector<int> vc2(n - 1);
  vector<int> vc3(n - 2);
  for (int i = 0; i < n; i++) cin >> vc1[i];
  for (int i = 0; i < n - 1; i++) cin >> vc2[i];
  for (int i = 0; i < n - 2; i++) cin >> vc3[i];
  sort(vc1.begin(), vc1.end());
  sort(vc2.begin(), vc2.end());
  sort(vc3.begin(), vc3.end());
  for (int i = 0; i < n - 1; i++) {
    if (vc2[i] != vc1[i]) {
      a = vc1[i];
      break;
    }
  }
  if (a == 0) a = vc1[n - 1];
  for (int i = 0; i < n - 2; i++) {
    if (vc3[i] != vc2[i]) {
      b = vc2[i];
      break;
    }
  }
  if (b == 0) b = vc2[n - 2];
  cout << a << endl << b;
}
