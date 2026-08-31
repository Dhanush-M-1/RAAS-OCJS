#include <bits/stdc++.h>
using namespace std;
long long int q;
vector<int> prime, fector;
bool ara[10000000];
void makevector(int q) {
  for (int i = 0; i < q; i++) {
    if (ara[i]) prime.push_back(i);
  }
}
void makeprime(int q) {
  int n = sqrt(q) + 1;
  ara[0] = false;
  ara[1] = false;
  for (int i = 4; i < q; i += 2) {
    ara[i] = false;
  }
  for (int i = 3; i < n; i += 2) {
    if (ara[i]) {
      for (int j = i * i; j < q; j += i) ara[j] = false;
    }
  }
  makevector(q);
}
bool isprime(long long int q) {
  for (int i = 0; i < prime.size(); i++) {
    if (q % prime[i] == 0) return false;
  }
  return true;
}
void makefector(long long int q) {
  for (int i = 0; i < prime.size() || q > 1;) {
    if (q % prime[i] == 0) {
      q = q / prime[i];
      fector.push_back(prime[i]);
    } else if (i == prime.size() - 1 && q != 1) {
      fector.push_back(q);
      q = 1;
    } else
      i++;
  }
  return;
}
int main() {
  memset(ara, true, sizeof(ara));
  cin >> q;
  makeprime(2 * sqrt(q) + 1);
  if (isprime(q) || q == 1 || q == 2 || q == 3) {
    cout << "1" << endl;
    cout << "0" << endl;
    return 0;
  }
  makefector(q);
  if (fector.size() == 2)
    cout << "2" << endl;
  else {
    cout << "1" << endl;
    cout << fector[0] * fector[1] << endl;
  }
  return 0;
}
