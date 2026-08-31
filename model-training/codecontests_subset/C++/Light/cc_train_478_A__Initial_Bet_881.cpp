#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
const long long INF = 1e9;
using namespace std;
void solution() {
  int sum = 0;
  for (int i = 0; i < 5; i++) {
    int c;
    cin >> c;
    sum += c;
  }
  auto value = sum / 5.0;
  if (value == 0.0)
    cout << -1;
  else if (int(value) == value)
    cout << value;
  else
    cout << -1;
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solution();
  return 0;
}
