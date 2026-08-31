#include <bits/stdc++.h>
using namespace std;
typedef struct {
  int home;
  int guest;
} k;
int main() {
  int m, n, ans = 0, w;
  cin >> n;
  k *v;
  v = new k[n];
  for (int i = 0; i < n; i++) {
    cin >> v[i].home >> v[i].guest;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (j != i && v[i].home == v[j].guest) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
