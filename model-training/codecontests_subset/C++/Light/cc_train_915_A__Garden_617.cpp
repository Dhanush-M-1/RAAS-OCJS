#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int n, k;
  cin >> n >> k;
  vector<int> a(n);
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a.begin(), a.end(), greater<int>());
  for (int i = 0; i < n; i++) {
    if (a[i] <= k && k % a[i] == 0) {
      printf("%d\n", k / a[i]);
      return 0;
    }
  }
  return 0;
}
