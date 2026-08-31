#include <bits/stdc++.h>
using namespace std;
const int N = 1000 * 1000;
const long long int inf = 1000ll * 1000 * 1000 * 1000 * 1000;
int n, m, k;
int block[N];
int price[N + 1];
int last[N];
void read();
void initialize();
long long int ans();
int numberOfLamps(int);
int main() {
  read();
  initialize();
  cout << ans() << endl;
  return 0;
}
void read() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int b;
    cin >> b;
    block[b] = true;
  }
  for (int i = 1; i <= k; i++) cin >> price[i];
}
void initialize() {
  int l = -1;
  for (int i = 0; i < n; i++) {
    if (!block[i]) l = i;
    last[i] = l;
  }
}
long long int ans() {
  if (block[0]) return -1;
  int con = 0;
  int maximum = 0;
  for (int i = 1; i < n; i++) {
    if (block[i])
      con++;
    else
      con = 0;
    maximum = max(maximum, con);
  }
  if (k <= maximum) return -1;
  long long int res = inf;
  for (int p = maximum + 1; p <= k; p++) {
    long long int number = numberOfLamps(p);
    long long int cost = price[p] * number;
    res = min(res, cost);
  }
  return res;
}
int numberOfLamps(int p) {
  int number = 0;
  int lamp = 0;
  int bound = p;
  while (bound < n) {
    number++;
    lamp = last[bound];
    bound = lamp + p;
  }
  return number + 1;
}
