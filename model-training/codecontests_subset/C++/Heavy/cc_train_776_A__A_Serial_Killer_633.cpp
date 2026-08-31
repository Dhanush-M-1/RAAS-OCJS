#include <bits/stdc++.h>
using namespace std;
double maxd(double a, double b) {
  if (a >= b) {
    return a;
  }
  return b;
}
double mind(double a, double b) {
  if (a <= b) {
    return a;
  }
  return b;
}
long long gcd(long long a, long long b) {
  if (a < b) {
    swap(a, b);
  }
  while (b) {
    long long r = a % b;
    a = b;
    b = r;
  }
  return a;
}
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
int isPrim(int a) {
  if (a == 1) {
    return 0;
  }
  for (int i = 2; i <= (a + 1) / 2; i++) {
    if (a % i == 0) {
      return 0;
    }
  }
  return 1;
}
long long mod_pow(long long x, long long n, long long mod) {
  long long ret = 1;
  while (n > 0) {
    if (n % 2 == 1) {
      ret = (ret * x) % mod;
    }
    x = (x * x) % mod;
    n = n / 2;
  }
  return ret;
}
struct XX {
  int u;
  int v;
  int t;
};
class xxIntu {
 public:
  bool operator()(const XX& riLeft, const XX& riRight) const {
    if ((riLeft.t) == (riRight.t)) {
      return riLeft.u < riRight.u;
    }
    return (riLeft.t) < (riRight.t);
  }
};
int index(string in) {
  if (in == "A") {
    return 0;
  } else if (in == "B") {
    return 1;
  } else if (in == "C") {
    return 2;
  } else if (in == "D") {
    return 3;
  } else if (in == "E") {
    return 4;
  } else if (in == "F") {
    return 5;
  } else if (in == "G") {
    return 6;
  } else if (in == "H") {
    return 7;
  } else if (in == "I") {
    return 8;
  } else if (in == "J") {
    return 9;
  } else if (in == "K") {
    return 10;
  } else if (in == "L") {
    return 11;
  } else if (in == "M") {
    return 12;
  } else if (in == "N") {
    return 13;
  } else if (in == "O") {
    return 14;
  } else if (in == "P") {
    return 15;
  } else if (in == "Q") {
    return 16;
  } else if (in == "R") {
    return 17;
  } else if (in == "S") {
    return 18;
  } else if (in == "T") {
    return 19;
  } else if (in == "U") {
    return 20;
  } else if (in == "V") {
    return 21;
  } else if (in == "W") {
    return 22;
  } else if (in == "X") {
    return 23;
  } else if (in == "Y") {
    return 24;
  } else if (in == "Z") {
    return 25;
  }
  return -1;
}
string rindex(int in) {
  if (in == 65) {
    return "A";
  } else if (in == 66) {
    return "B";
  } else if (in == 67) {
    return "C";
  } else if (in == 68) {
    return "D";
  } else if (in == 69) {
    return "E";
  } else if (in == 70) {
    return "F";
  } else if (in == 71) {
    return "G";
  } else if (in == 72) {
    return "H";
  } else if (in == 73) {
    return "I";
  } else if (in == 74) {
    return "J";
  } else if (in == 75) {
    return "K";
  } else if (in == 76) {
    return "L";
  } else if (in == 77) {
    return "M";
  } else if (in == 78) {
    return "N";
  } else if (in == 79) {
    return "O";
  } else if (in == 80) {
    return "P";
  } else if (in == 81) {
    return "Q";
  } else if (in == 82) {
    return "R";
  } else if (in == 83) {
    return "S";
  } else if (in == 84) {
    return "T";
  } else if (in == 85) {
    return "U";
  } else if (in == 86) {
    return "V";
  } else if (in == 87) {
    return "W";
  } else if (in == 88) {
    return "X";
  } else if (in == 89) {
    return "Y";
  } else if (in == 90) {
    return "Z";
  }
  return "";
}
int ppar[200001];
int rrank[200001];
void init(int n) {
  for (int i = 1; i <= n; i++) {
    ppar[i] = i;
    rrank[i] = 0;
  }
}
int find(int x) {
  if (ppar[x] == x) {
    return x;
  } else {
    return ppar[x] = find(ppar[x]);
  }
}
void unite(int x, int y) {
  x = find(x);
  y = find(y);
  if (x == y) {
    return;
  }
  if (rrank[x] < rrank[y]) {
    ppar[x] = ppar[y];
  } else {
    ppar[y] = x;
    if (rrank[x] == rrank[y]) {
      rrank[x]++;
    }
  }
}
bool same(int x, int y) { return find(x) == find(y); }
struct edge {
  int u;
  int v;
  int cost;
};
bool comp(edge& e1, edge& e2) { return e1.cost < e2.cost; }
edge es[1000];
int V, E;
int ans = 0;
int kruskal() {
  sort(es, es + E, comp);
  init(V);
  int res = 0;
  for (int i = 0; i < E; i++) {
    edge e = es[i];
    if (!same(e.u, e.v)) {
      unite(e.u, e.v);
      res += e.cost;
      ans++;
    }
  }
  return res;
}
int main(int argc, const char* argv[]) {
  string s1, s2;
  int n;
  cin >> s1 >> s2 >> n;
  string kil[1000];
  string rep[1000];
  for (int i = 0; i < n; i++) {
    cin >> kil[i] >> rep[i];
  }
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    if (s1 == kil[i]) {
      s1 = rep[i];
    } else {
      s2 = rep[i];
    }
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
