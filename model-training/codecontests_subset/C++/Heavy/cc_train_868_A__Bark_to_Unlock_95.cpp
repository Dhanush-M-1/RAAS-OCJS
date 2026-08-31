#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e7;
const long long MOD = 1e9 + 7;
const long long maxn = 1e5 + 1;
long long RAND(long long n) { return abs((rand() << 15) + rand()) % n; }
void solveTask() {
  long long n;
  string second, s1[1000];
  int res = 0, res1 = 0;
  bool ans = 0, c = 0, z = 0, x = 0, y = 0;
  cin >> second;
  cin >> n;
  res1 = (int)second[0] + (int)second[1];
  for (int i = 0; i < n; ++i) {
    cin >> s1[i];
    if (s1[i][1] == second[0]) x = 1;
    if (s1[i][0] == second[1]) y = 1;
    if (s1[i] == second || (s1[i][0] == second[1] && s1[i][1] == second[0]))
      ans = 1;
  }
  if (ans || (x && y))
    cout << "YES";
  else
    cout << "NO";
}
int main() {
  ios_base::sync_with_stdio(0);
  srand(time(0));
  solveTask();
  return 0;
}
