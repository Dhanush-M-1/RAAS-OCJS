#include <bits/stdc++.h>
using namespace std;
namespace kotespace {
template <class T>
class duplet {
 private:
 public:
  T x, y;
  duplet(){};
  duplet(T a, T b) : x(a), y(b){};
  bool operator<(const duplet P) const {
    return (x < P.x || (x == P.x && y < P.y));
  }
  bool operator>(const duplet P) const {
    return (x > P.x || (x == P.x && y > P.y));
  }
  bool operator==(const duplet P) const { return (x == P.x && y == P.y); }
  bool operator!=(const duplet P) const { return (x != P.x || y != P.y); }
  void reverse() { std::swap(x, y); }
};
template <class P>
istream &operator>>(istream &in, duplet<P> &T) {
  return (in >> T.x >> T.y);
}
template <class P>
ostream &operator<<(ostream &out, duplet<P> T) {
  return (out << T.x << " " << T.y);
}
template <class T>
class triplet {
 private:
 public:
  T x, y, z;
  triplet(){};
  triplet(T a, T b, T c) : x(a), y(b), z(c){};
  bool operator<(const triplet P) const {
    return (x < P.x || (x == P.x && y < P.y) ||
            (x == P.x && y == P.y && z < P.z));
  }
  bool operator>(const triplet P) const {
    return (x > P.x || (x == P.x && y > P.y) ||
            (x == P.x && y == P.y && z > P.z));
  }
  bool operator==(const triplet P) const {
    return (x == P.x && y == P.y && z == P.z);
  }
  bool operator!=(const triplet P) const {
    return (x != P.x || y != P.y || z != P.z);
  }
  void reverse() { std::swap(x, z); }
  void cycle_right(int a) {
    if (a == 1) {
      std::swap(x, y);
      std::swap(x, z);
    }
    if (a == 2) {
      std::swap(x, z);
      std::swap(y, x);
    }
  }
  void cycle_left(int a) {
    if (a == 1) {
      std::swap(x, z);
      std::swap(y, x);
    }
    if (a == 2) {
      std::swap(x, y);
      std::swap(x, z);
    }
  }
};
template <class P>
istream &operator>>(istream &in, triplet<P> &T) {
  return (in >> T.x >> T.y >> T.z);
}
template <class P>
ostream &operator<<(ostream &out, triplet<P> &T) {
  return (out << T.x << " " << T.y << " " << T.z);
}
}  // namespace kotespace
using namespace kotespace;
long long inf = 1000 * 1000 * 1000 + 5;
long long inf64 = inf * inf;
long long mod = 228228227;
vector<duplet<int> > a;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cerr << fixed << setprecision(10);
  cout << fixed << setprecision(10);
  srand(time(0));
  float START_TIME = clock();
  int n;
  cin >> n;
  a.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i].x;
    a[i].x *= -1;
    a[i].y = i;
  }
  sort(a.begin(), a.end());
  int k;
  cin >> k;
  for (int i = 0; i < k; ++i) {
    int x, y;
    cin >> x >> y;
    vector<duplet<int> > b;
    for (int j = 0; j < x; ++j) {
      b.emplace_back(a[j].y, -a[j].x);
    }
    sort(b.begin(), b.end());
    cout << b[y - 1].y << endl;
  }
  cerr << endl << (clock() - START_TIME) / CLOCKS_PER_SEC << " sec." << endl;
}
