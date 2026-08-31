#include <bits/stdc++.h>
using namespace std;
vector<int> pmin(2 * 262144);
vector<int> pmax(2 * 262144);
void muutaMin(int k, int x) {
  k += 262144;
  pmin[k] = x;
  for (k /= 2; k >= 1; k /= 2) {
    pmin[k] = pmin[2 * k] + pmin[2 * k + 1];
  }
}
int summaMin(int a, int b) {
  a += 262144;
  b += 262144;
  int s = 0;
  while (a <= b) {
    if (a % 2 == 1) {
      s += pmin[a];
      a++;
    }
    if (b % 2 == 0) {
      s += pmin[b];
      b--;
    }
    a /= 2;
    b /= 2;
  }
  return s;
}
void muutaMax(int k, int x) {
  k += 262144;
  pmax[k] = x;
  for (k /= 2; k >= 1; k /= 2) {
    pmax[k] = pmax[2 * k] + pmax[2 * k + 1];
  }
}
int summaMax(int a, int b) {
  a += 262144;
  b += 262144;
  int s = 0;
  while (a <= b) {
    if (a % 2 == 1) {
      s += pmax[a];
      a++;
    }
    if (b % 2 == 0) {
      s += pmax[b];
      b--;
    }
    a /= 2;
    b /= 2;
  }
  return s;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int day, orders;
      cin >> day >> orders;
      int curMin = summaMin(day, day);
      curMin = min(b, curMin + orders);
      muutaMin(day, curMin);
      int curMax = summaMax(day, day);
      curMax = min(a, curMax + orders);
      muutaMax(day, curMax);
    } else {
      int p;
      cin >> p;
      long long sum1 = summaMin(0, p - 1);
      long long sum2 = summaMax(p + k, 262144);
      cout << sum1 + sum2 << "\n";
    }
  }
}
