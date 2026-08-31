#include <bits/stdc++.h>
using namespace std;
vector<long long> pr;
int main() {
  long long q;
  cin >> q;
  long long tp = q;
  for (long long i = 2; i * i <= q; i++) {
    while (tp % i == 0) {
      pr.push_back(i);
      tp = tp / i;
    }
  }
  if (tp > 2) pr.push_back(tp);
  if (pr.size() > 2)
    cout << "1\n" << pr[0] * pr[1] << endl;
  else if (pr.size() < 2)
    cout << "1\n"
         << "0" << endl;
  else
    cout << "2" << endl;
}
