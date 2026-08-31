#include <bits/stdc++.h>
using namespace std;
const int INF = (-1u) / 2;
const long long int INF2 = (-1ull) / 2;
int a, b, i, d[1011000], j, k, n, m, timer = 0, l, r, x, y;
int c[1011000], cnt = 0, fl = 0, a2, a3 = -1000000, ans = 0;
void deb(bool a) {
  if (a) return;
  printf("PROGRAM TERMINATED\n");
  exit(0);
}
char prevv, nw;
vector<int> v;
int main() {
  prevv = '+';
  cin >> nw;
  x++;
  v.push_back(1);
  while (1) {
    cin >> prevv;
    if (prevv == '=') break;
    cin >> nw;
    if (prevv == '+')
      v.push_back(1), x++;
    else
      v.push_back(-1), y++;
  }
  cin >> n;
  if (!((1 * x - n * y) <= n && n <= (n * x - 1 * y))) {
    cout << "Impossible\n";
    return 0;
  }
  ans = 0;
  cout << "Possible\n";
  for (i = 0; i < v.size(); i++) {
    if (v[i] == 1)
      x--;
    else
      y--;
    for (j = 1; j <= n; j++) {
      if (((1 * x - n * y) <= (n - (ans + v[i] * j)) &&
           (n - (ans + v[i] * j)) <= (n * x - 1 * y)))
        break;
    }
    ans += (v[i] * j);
    if (i == 0)
      cout << j << " ";
    else if (v[i] == 1)
      cout << "+ " << j << " ";
    else if (v[i] == -1)
      cout << "- " << j << " ";
  }
  cout << "= " << n << endl;
  return 0;
}
