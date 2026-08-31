#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<int> v;
  long long nn = n;
  for (int i = 2; 1ll * i * i <= nn; i++) {
    while (n % i == 0) {
      n /= i;
      v.push_back(i);
    }
  }
  if (n > 1) v.push_back(n);
  if (v.size() == 1 || v.empty()) {
    puts("1");
    puts("0");
  } else if (v.size() == 2)
    puts("2");
  else {
    puts("1");
    cout << 1ll * v[0] * v[1] << endl;
  }
}
