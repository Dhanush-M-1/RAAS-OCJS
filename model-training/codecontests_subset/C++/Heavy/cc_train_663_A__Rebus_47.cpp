#include <bits/stdc++.h>
using namespace std;
int d, marime_minima, marime_maxima;
int n,
    afara_ninge_linistit_si_n_casa_arde_focul_iar_noi_pe_langa_mama_stand_de_mult_uitaram_jocul,
    sum;
vector<char> operatie_de_marire;
int pula, un_pumn_in_cap_it_dau;
char c;
inline void DaCuBanii() {
  while (cin >> c) {
    if (c == '?')
      afara_ninge_linistit_si_n_casa_arde_focul_iar_noi_pe_langa_mama_stand_de_mult_uitaram_jocul++;
    if (c == '=') {
      if (afara_ninge_linistit_si_n_casa_arde_focul_iar_noi_pe_langa_mama_stand_de_mult_uitaram_jocul ==
          0) {
        cout << "Impossible\n";
        exit(0);
      }
      cin >> n;
      break;
    }
    if (c == '+') {
      pula++;
      operatie_de_marire.push_back(c);
    }
    if (c == '-') {
      un_pumn_in_cap_it_dau++;
      operatie_de_marire.push_back(c);
    }
  }
}
inline void SaMoareDusmanii() {
  if (pula == un_pumn_in_cap_it_dau) {
    cout << "Possible\n";
    cout << n << " ";
    for (__typeof((operatie_de_marire).begin()) it =
             (operatie_de_marire).begin();
         it != (operatie_de_marire).end(); it++)
      cout << *it << " " << 1 << " ";
    cout << "= " << n;
    exit(0);
  }
  marime_maxima = n;
  marime_minima = 1;
  for (__typeof((operatie_de_marire).begin()) it = (operatie_de_marire).begin();
       it != (operatie_de_marire).end(); it++) {
    if (*it == '+') {
      marime_maxima += n;
      marime_minima++;
    } else {
      marime_maxima--;
      marime_minima -= n;
    }
  }
  if (n >= marime_minima && n <= marime_maxima)
    cout << "Possible\n";
  else {
    cout << "Impossible\n";
    exit(0);
  }
  sum = n;
  if (pula > un_pumn_in_cap_it_dau) {
    sum += n * un_pumn_in_cap_it_dau;
    d = sum - pula - 1;
    cout << min(n - 1, d) + 1 << " ";
    d -= min(n - 1, d);
    for (__typeof((operatie_de_marire).begin()) it =
             (operatie_de_marire).begin();
         it != (operatie_de_marire).end(); it++) {
      if (*it == '-')
        cout << "- " << n << " ";
      else {
        cout << "+ " << min(n - 1, d) + 1 << " ";
        d -= min(n - 1, d);
      }
    }
    cout << "= " << n;
    exit(0);
  }
}
inline void DaiSaPuta() {
  sum = pula * n;
  d = sum - un_pumn_in_cap_it_dau;
  cout << n << " ";
  for (__typeof((operatie_de_marire).begin()) it = (operatie_de_marire).begin();
       it != (operatie_de_marire).end(); it++) {
    if (*it == '+')
      cout << "+ " << n << " ";
    else {
      cout << "- " << min(n - 1, d) + 1 << " ";
      d -= min(n - 1, d);
    }
  }
  cout << "= " << n;
}
int main() {
  cin.sync_with_stdio(false);
  cin.tie(NULL);
  DaCuBanii();
  SaMoareDusmanii();
  DaiSaPuta();
  return 0;
}
