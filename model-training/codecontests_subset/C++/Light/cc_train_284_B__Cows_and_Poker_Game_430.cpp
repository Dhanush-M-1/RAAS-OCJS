#include <bits/stdc++.h>
using namespace std;
struct coo {
  long long a, b, c, d;
};
bool comp(struct coo a, struct coo b) { return a.a < b.a; }
int main() {
  long long n, m;
  long long i, j, k;
  long long x;
  long long t;
  cin >> n;
  string a;
  cin >> a;
  int l = a.size();
  int couna = 0, couni = 0;
  for (i = 0; i < l; i++) {
    if (a[i] == 'A') couna++;
    if (a[i] == 'I') couni++;
  }
  if (couni == 0) {
    cout << couna << endl;
    return 0;
  }
  if (couni == 1) {
    cout << 1 << endl;
    return 0;
  }
  cout << 0 << endl;
  return 0;
}
