#include <bits/stdc++.h>
using namespace std;
int n, m, a, numer, tab[1000007], ile[1000007], last[1000007], nxt[1000007],
    fst[1000007], bl[1000007];
int maks, best;
int *first, *byl;
int pref[1000007], prv[1000007];
int second(int i, int j) { return pref[i] - pref[j + 1]; }
int main() {
  first = fst + 500002;
  byl = bl + 500002;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &tab[i]);
    ile[tab[i]]++;
    if (ile[tab[i]] > maks) {
      maks = ile[tab[i]];
      best = tab[i];
    }
  }
  for (int i = n - 1; i >= 0; i--) {
    pref[i] = (tab[i] == best) + pref[i + 1];
  }
  for (int i = n; i >= 1; i--) last[i] = n;
  for (int i = n - 1; i >= 0; i--) {
    nxt[i] = last[tab[i]];
    last[tab[i]] = i;
  }
  int lst = 0;
  for (int i = 0; i <= n; i++) {
    prv[i] = lst;
    if (tab[i] == best) {
      lst = i;
    }
  }
  int res = 0;
  for (int nr = 1; nr <= n; nr++) {
    numer++;
    if (ile[nr] > 0 && nr != best) {
      if (ile[nr] * ile[nr] >= n) {
        int pn = last[nr];
        int pb = last[best];
        int suma = 0;
        int prev = -1;
        while (prev < n) {
          int poz = min(pn, pb);
          if (byl[suma] != numer) {
            byl[suma] = numer;
            first[suma] = prev;
          } else {
            res = max(res, poz - first[suma] - 1);
          }
          if (pn < pb) {
            suma--;
            pn = nxt[pn];
          } else {
            suma++;
            pb = nxt[pb];
          }
          prev = poz;
        }
      } else {
        int pn = last[nr];
        int pb = last[best];
        int suma = 0;
        int prev = -1;
        int ilbest = 0;
        while (prev < n) {
          int poz = min(pn, pb);
          if (byl[suma] != numer) {
            byl[suma] = numer;
            first[suma] = prev;
          } else {
            res = max(res, poz - first[suma] - 1);
          }
          if (pn < pb) {
            suma--;
            pn = nxt[pn];
            ilbest = 0;
          } else {
            suma++;
            pb = nxt[pb];
            ilbest++;
          }
          prev = poz;
          if (ilbest == ile[nr] + 1) {
            pb = pn;
            for (int x = 0; x < ile[nr] + 1; x++) {
              pb = prv[pb];
            }
            numer++;
          }
        }
      }
    }
  }
  printf("%d\n", res);
  return 0;
}
