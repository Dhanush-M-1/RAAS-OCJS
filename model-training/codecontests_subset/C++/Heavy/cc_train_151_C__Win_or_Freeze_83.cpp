#include <bits/stdc++.h>
using namespace std;
bool arr[10000005];
void sieve() {
  for (int i = 3; i * i <= 10000000; i += 2) {
    if (arr[i] == 0) {
      for (int j = i * i; j <= 10000000; j += i) arr[j] = 1;
    }
  }
}
vector<long long> pr, vv;
long long q;
void DIV() {
  long long p = q;
  for (int i = 0; i < pr.size() && pr[i] <= p; i++) {
    if (p % pr[i] == 0) {
      while (p % pr[i] == 0) {
        p /= pr[i];
      }
      vv.push_back(pr[i]);
    }
  }
  if (p > 1) vv.push_back(p);
}
int main() {
  sieve();
  pr.push_back(2);
  for (int i = 3; i <= 10000000; i += 2) {
    if (arr[i] == 0) pr.push_back(i);
  }
  scanf("%I64d", &q);
  if (q == 1) {
    printf("1\n0\n");
    return 0;
  }
  DIV();
  if (vv.size() == 0) {
    cout << "1" << endl << "0" << endl;
  } else if (vv.size() == 1 && vv[0] == q) {
    cout << "1" << endl << "0" << endl;
  } else if (vv.size() == 1 && vv[0] * vv[0] == q) {
    cout << "2" << endl;
  } else if (vv.size() == 2 && vv[0] * vv[1] == q) {
    cout << "2" << endl;
  } else {
    long long ans;
    if (vv.size() == 1)
      ans = vv[0] * vv[0];
    else
      ans = vv[0] * vv[1];
    cout << "1" << endl << ans << endl;
  }
}
