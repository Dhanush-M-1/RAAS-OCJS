#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using pi = pair<int, int>;
int a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> a >> b >> c;
  int temp = (a - b) * c;
  cout << ceil((double)temp / b) << '\n';
}
