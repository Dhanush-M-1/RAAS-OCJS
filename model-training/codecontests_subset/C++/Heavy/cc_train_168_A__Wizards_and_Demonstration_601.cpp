#include <bits/stdc++.h>
using namespace std;
const bool OJ = true;
const long long inf = 1LL << 60;
template <class T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (long long i = 0; i < (((long long)((v).size()))); i++) os << v[i] << " ";
  return os;
}
template <class T>
istream& operator>>(istream& is, vector<T>& v) {
  for (long long i = 0; i < (((long long)((v).size()))); i++) is >> v[i];
  return is;
}
template <class A, class B>
istream& operator>>(istream& is, tuple<A, B>& p) {
  is >> get<0>(p) >> get<1>(p);
  return is;
}
void run() {
  long long n, x, y;
  cin >> n >> x >> y;
  long long a = n * y;
  long long b = ((a) / (100) + (0 < ((a) % (100))));
  if (x > b) {
    cout << 0 << endl;
  } else {
    cout << b - x << endl;
  }
}
int main(int argc, char* argv[]) {
  run();
  return 0;
}
