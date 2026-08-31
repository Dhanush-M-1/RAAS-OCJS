#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  v.assign(1000001, 0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    v[a] = 1;
  }
  int cont = 0;
  int me = 1, fri = 1000000;
  int answer = 0;
  while (cont < n) {
    if (v[me] == 1) {
      v[me] = 0;
      ++cont;
    }
    if (v[fri] == 1) {
      v[fri] = 0;
      ++cont;
    }
    --fri;
    ++me;
    ++answer;
  }
  cout << answer - 1 << "\n";
  return 0;
}
