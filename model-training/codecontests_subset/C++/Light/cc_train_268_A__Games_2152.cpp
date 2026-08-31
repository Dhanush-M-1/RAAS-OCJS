#include <bits/stdc++.h>
using namespace std;
map<int, int> mark1;
map<int, int> mark2;
int a[10000], b[10000], t;
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i] >> b[i];
    mark1[a[i]]++;
    mark2[b[i]]++;
  }
  for (int i = 1; i <= n; i++) {
    t += mark1[b[i]];
  }
  cout << t;
}
