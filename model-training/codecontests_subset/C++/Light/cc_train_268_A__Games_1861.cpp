#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
int main() {
  int n;
  cin >> n;
  vector<int> home(n);
  vector<int> out(n);
  int count = 0;
  for (int i = 0; i < n; i++) {
    cin >> home[i];
    cin >> out[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i == j) continue;
      int n1 = home[i];
      int n2 = out[j];
      if (n1 == n2) count++;
    }
  }
  cout << count;
}
