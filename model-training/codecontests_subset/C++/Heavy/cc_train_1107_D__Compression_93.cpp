#include <bits/stdc++.h>
using namespace std;
int oneh[5209][5209], onev[5209][5209];
string qn[5209];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  vector<int> fac;
  for (long long int i = 1; i <= n; i++) {
    if (n % i == 0) fac.push_back(i);
  }
  fac.push_back(n);
  long long int sz = fac.size();
  for (long long int i = 1; i <= n; i++) qn[i] = qn[i] + " ";
  for (long long int i = 1; i <= n; i++) {
    string s;
    cin >> s;
    long long int yo = n / 4;
    for (long long int j = 0; j <= yo - 1; j++) {
      switch (s[j]) {
        case '0':
          qn[i] += "0000";
          break;
        case '1':
          qn[i] += "0001";
          break;
        case '2':
          qn[i] += "0010";
          break;
        case '3':
          qn[i] += "0011";
          break;
        case '4':
          qn[i] += "0100";
          break;
        case '5':
          qn[i] += "0101";
          break;
        case '6':
          qn[i] += "0110";
          break;
        case '7':
          qn[i] += "0111";
          break;
        case '8':
          qn[i] += "1000";
          break;
        case '9':
          qn[i] += "1001";
          break;
        case 'A':
          qn[i] += "1010";
          break;
        case 'B':
          qn[i] += "1011";
          break;
        case 'C':
          qn[i] += "1100";
          break;
        case 'D':
          qn[i] += "1101";
          break;
        case 'E':
          qn[i] += "1110";
          break;
        case 'F':
          qn[i] += "1111";
          break;
      }
    }
  }
  for (long long int i = 0; i <= n; i++) {
    onev[0][i] = 0;
    oneh[0][i] = 0;
    onev[i][0] = 0;
    oneh[i][0] = 0;
  }
  for (long long int i = 1; i <= n; i++) {
    for (long long int j = 1; j <= n; j++) {
      if (qn[i][j] == '0') {
        oneh[i][j] = oneh[i - 1][j];
      } else {
        oneh[i][j] = oneh[i - 1][j] + 1;
      }
    }
  }
  for (long long int i = 1; i <= n; i++) {
    for (long long int j = 1; j <= n; j++) {
      { onev[i][j] = onev[i][j - 1] + oneh[i][j]; }
    }
  }
  for (long long int i1 = sz - 1; i1 >= 0; i1--) {
    long long int req = fac[i1];
    long long int haa = n / req;
    int fou = 1;
    long long int da = req * req;
    for (long long int i = 1; i <= haa; i++) {
      for (long long int j = 1; j <= haa; j++) {
        if ((((onev[i * req][j * req] - onev[(i - 1) * req][j * req]) % da !=
              0)) ||
            ((onev[i * req][j * req] - onev[(i)*req][(j - 1) * req]) % da !=
             0)) {
          fou = 0;
          break;
        }
      }
    }
    if (fou == 1) {
      cout << fac[i1] << endl;
      return 0;
    }
  }
  return 0;
}
