#include <bits/stdc++.h>
using namespace std;
unsigned long long int gcd(unsigned long long int a, unsigned long long int b) {
  if (b == 0) return a;
  a %= b;
  return gcd(b, a);
}
unsigned long long int power(unsigned long long int x, unsigned long long int y,
                             unsigned long long int md = 998244353) {
  unsigned long long int res = 1;
  x %= md;
  while (y > 0) {
    if (y & 1) res = (res * x) % md;
    x = (x * x) % md;
    y = y >> 1;
  }
  return res % md;
}
bool sortbysec(const pair<unsigned long long int, unsigned long long int> &a,
               const pair<unsigned long long int, unsigned long long int> &b) {
  return (a.second < b.second);
}
unsigned long long int len(unsigned long long int v) {
  unsigned long long int len = 0;
  while (v > 0) {
    v /= 10;
    len++;
  }
  return len;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  unsigned long long int n;
  cin >> n;
  unsigned long long int arr[n], temp;
  map<unsigned long long int, unsigned long long int> make_pair;
  for (unsigned long long int i = 0; i < n; i++) {
    cin >> arr[i];
    temp = len(arr[i]);
    make_pair[temp]++;
  }
  map<unsigned long long int, unsigned long long int>::iterator it;
  unsigned long long int maxx = 0, cnt = 0;
  for (it = make_pair.begin(); it != make_pair.end(); it++) {
    if (it->first > maxx) maxx = it->first;
    cnt++;
  }
  unsigned long long int sum = 0;
  unsigned long long int brr[20], crr[20];
  for (unsigned long long int i = 0; i < n; i++) {
    memset(brr, 0, sizeof(brr));
    memset(crr, 0, sizeof(crr));
    string c = "";
    unsigned long long int temp = arr[i], temp2;
    while (temp > 0) {
      temp2 = temp % 10;
      temp /= 10;
      c += (char)(48 + temp2);
    }
    string temp3 = c, temp4;
    for (unsigned long long int j = 0; j < c.length(); j++) {
      temp3.insert(j * 2, "0");
      temp4 = temp3;
      reverse(temp4.begin(), temp4.end());
      unsigned long long int tt = 0;
      for (unsigned long long int k = 0; k < temp4.length(); k++) {
        tt *= 10;
        tt += temp4[k] - '0';
      }
      brr[j + 1] = tt;
    }
    for (unsigned long long int i = 1; i < 20; i++) {
      crr[i - 1] = brr[i] / 10;
    }
    for (unsigned long long int i = 1; i < 20; i++) {
      if (brr[i] == 0) brr[i] = brr[i - 1];
      if (crr[i] == 0) crr[i] = crr[i - 1];
    }
    it = make_pair.begin();
    while (it != make_pair.end()) {
      sum += (((it->second) % 998244353) * (brr[it->first] % 998244353)) %
             998244353;
      sum %= 998244353;
      sum += (((it->second) % 998244353) * (crr[it->first] % 998244353)) %
             998244353;
      sum %= 998244353;
      it++;
    }
  }
  cout << sum % 998244353 << '\n';
  return 0;
}
