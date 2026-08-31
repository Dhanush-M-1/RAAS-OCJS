#include <bits/stdc++.h>
using namespace std;
using namespace std;
class BIT {
 public:
  int tree[100002 + 1];
  BIT() { memset(tree, 0, sizeof(tree)); }
  void update(int index, int val) {
    while (index <= 100002) {
      tree[index] += val;
      index += (index & -index);
    }
  }
  int query(int index) {
    int sum = 0;
    while (index > 0) {
      sum += tree[index];
      index -= (index & -index);
    }
    return sum;
  }
  int readsingle(int index) {
    int sum = tree[index];
    int z = index - (index & -index);
    index--;
    while (index != z) {
      sum -= tree[index];
      index -= (index & -index);
    }
    return sum;
  }
};
BIT B;
int mx, my, w;
struct node {
  int num, n, d;
};
node N[100002];
int gcd(int a, int b) {
  if (a < b) swap(a, b);
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool cmp(node A, node B) {
  if (A.n == B.n) return A.d < B.d;
  return A.n < B.n;
}
map<pair<int, int>, int> MIN, MAX;
int R(int i) {
  stringstream s, ss;
  s << i;
  string r = s.str();
  s.clear();
  reverse(r.begin(), r.end());
  ss << r;
  int j;
  ss >> j;
  return j;
}
int main() {
  cin >> mx >> my >> w;
  int MX = max(mx, my);
  vector<int> vec[MX + 1];
  for (int i = 1; i < MX + 1; ++i) {
    int reverse = R(i);
    int g = gcd(i, reverse);
    int NN = i / g;
    int D = reverse / g;
    N[i].num = i;
    N[i].n = NN;
    N[i].d = D;
  }
  sort(N + 1, N + MX + 1, cmp);
  for (int i = 1; i < MX + 1; ++i) {
    pair<int, int> temp = make_pair(N[i].n, N[i].d);
    if (MIN[temp] == 0) {
      MIN[temp] = (1 << 22);
    }
    MIN[temp] = min(MIN[temp], i);
    MAX[temp] = max(MAX[temp], i);
  }
  int from = 1;
  for (int to = 1; to < MX + 2; ++to) {
    if (to == MX + 1 || !(N[to].n == N[from].n && N[to].d == N[from].d)) {
      int nr = N[from].d;
      int dr = N[from].n;
      pair<int, int> temp = make_pair(nr, dr);
      int L = MIN[temp], R = MAX[temp];
      if (R != 0) {
        for (int i = from; i < to; ++i) {
          for (int j = L; j < R + 1; ++j) {
            vec[N[i].num].push_back(N[j].num);
          }
        }
      }
      from = to;
    }
  }
  long long int prod = (1LL << 50), xx, yy;
  for (int i = 1; i < mx + 1; ++i) {
    int size = vec[i].size();
    for (int j = 0; j < size; ++j) {
      B.update(vec[i][j], 1);
    }
    int lo = 1, hi = my;
    for (int rep = 0; rep < 19; ++rep) {
      int mid = (lo + hi) >> 1;
      int prod = B.query(mid);
      if (prod < w) {
        lo = mid;
      } else
        hi = mid;
    }
    if (B.query(lo) >= w)
      lo = lo;
    else if (B.query(hi) >= w)
      lo = hi;
    else
      lo = -1;
    if (lo != -1) {
      long long int temp = (long long int)lo * i;
      if (temp < prod) {
        prod = temp;
        xx = i;
        yy = lo;
      }
    }
  }
  if (prod == (1LL << 50)) {
    cout << "-1";
  } else
    cout << xx << " " << yy;
  return 0;
}
