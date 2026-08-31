#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> v(n + 1, 0), kul(n + 1, 0), mime(n + 1, 0);
  long long neg = 0, poz = 0;
  long long ossz = 0;
  for (int i = 1; i < n + 1; i++) {
    cin >> v[i];
    kul[i] = v[i] - i;
    if (kul[i] <= 0)
      neg++;
    else
      poz++;
    ossz += (long long)abs(kul[i]);
    if (kul[i] > 0) mime[kul[i]]++;
  }
  long long ki = ossz, hely = 0;
  for (int i = 1; i < n; i++) {
    neg--;
    ossz += v[n - i + 1] - 1 - abs(kul[n - i + 1] - i + 1);
    if (v[n - i + 1] + i - 1 <= n) mime[v[n - i + 1] + i - 1]++;
    ossz += neg - poz;
    poz++;
    poz -= mime[i];
    neg += mime[i];
    if (ossz < ki) {
      ki = ossz;
      hely = i;
    }
  }
  cout << ki << " " << hely << endl;
  return 0;
}
