#include <bits/stdc++.h>
using namespace std;
template <class X>
void input(vector<X>& a, int N) {
  X temp;
  for (unsigned long long int i = 0; i < N; i++) {
    cin >> temp;
    a.push_back(temp);
  }
}
template <class X>
void output(vector<X>& a) {
  for (auto i = a.begin(); i != a.end(); i++) {
    cout << *i << " ";
  }
}
void solve() {
  set<int> alpha;
  int a, beta;
  int temp;
  cin >> a >> beta;
  for (unsigned long long int i = 0; i < a; i++) {
    vector<int> b;
    cin >> temp;
    input(b, temp);
    for (int p : b) {
      alpha.insert(p);
    }
  }
  for (int i = 1; i <= beta; i++) {
    if (find(alpha.begin(), alpha.end(), i) == alpha.end()) {
      cout << "NO";
      return;
    }
  }
  cout << "YES";
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
