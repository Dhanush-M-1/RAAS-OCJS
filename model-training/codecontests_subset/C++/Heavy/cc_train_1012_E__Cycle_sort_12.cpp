#include <bits/stdc++.h>
using namespace std;
struct ln {
  int val;
  ln* next;
};
vector<pair<int, int> >* nl;
vector<pair<int, int> > ar;
int* roi;
bool* btdt;
ln* fe(ln* ath, int cp) {
  ln* sv = NULL;
  ln* ov = NULL;
  for (int i = roi[cp]; i < nl[cp].size(); i = roi[cp]) {
    int np = nl[cp][i].first;
    int ind = nl[cp][i].second;
    if (btdt[ind]) {
      continue;
    }
    roi[cp]++;
    btdt[ind] = 1;
    ln* cn = new ln();
    cn->val = ind;
    cn->next = NULL;
    ln* vas = fe(cn, np);
    if (sv == NULL) {
      sv = cn;
      ov = vas;
      continue;
    }
    ath->next = cn;
    ath = vas;
  }
  if (sv != NULL) {
    ath->next = sv;
    ath = ov;
  }
  return ath;
}
int main() {
  cin.sync_with_stdio(0);
  cout.sync_with_stdio(0);
  int n, s;
  cin >> n >> s;
  int S = s;
  nl = new vector<pair<int, int> >[n];
  btdt = new bool[n];
  roi = new int[n];
  for (int i = 0; i < n; i++) {
    roi[i] = 0;
    vector<pair<int, int> > vpii;
    nl[i] = vpii;
    btdt[i] = 0;
    int a;
    cin >> a;
    ar.push_back(make_pair(a, i));
  }
  vector<pair<int, int> > br = ar;
  sort(br.begin(), br.end());
  unordered_map<int, int> nct;
  int cn = -1;
  int an = -1;
  for (int i = 0; i < n; i++) {
    if (br[i].first != an) {
      cn++;
      an = br[i].first;
      nct[an] = cn;
    }
    br[i].first = cn;
  }
  for (int i = 0; i < n; i++) {
    ar[i].first = nct[ar[i].first];
  }
  for (int i = 0; i < n; i++) {
    if (br[i].first == ar[i].first) {
      continue;
    }
    s--;
    nl[br[i].first].push_back(make_pair(ar[i].first, ar[i].second));
  }
  if (s < 0) {
    cout << -1 << "\n";
    return 0;
  }
  vector<ln*> atc;
  for (int i = 0; i < n; i++) {
    ln* tn = new ln();
    tn->val = -1;
    tn->next = NULL;
    ln* on = fe(tn, i);
    if (on != tn) {
      atc.push_back(tn->next);
    }
  }
  int noc = atc.size();
  int hmg = min(s, noc);
  vector<vector<int> > vas;
  if (hmg == 1) {
    hmg--;
  }
  if (hmg > 0) {
    if (S == 198000) {
    }
    vector<int> fv;
    vector<int> sv;
    for (int i = hmg - 1; i >= 0; i--) {
      fv.push_back(atc[i]->val);
    }
    for (int i = 0; i < hmg; i++) {
      int oi = i - 1;
      if (oi < 0) {
        oi += hmg;
      }
      sv.push_back(atc[oi]->val);
      ln* cn = atc[i]->next;
      while (cn != NULL) {
        sv.push_back(cn->val);
        cn = cn->next;
      }
    }
    vas.push_back(fv);
    vas.push_back(sv);
  }
  for (int i = hmg; i < atc.size(); i++) {
    vector<int> sv;
    ln* cn = atc[i];
    while (cn != NULL) {
      sv.push_back(cn->val);
      cn = cn->next;
    }
    vas.push_back(sv);
  }
  cout << vas.size() << "\n";
  for (int i = 0; i < vas.size(); i++) {
    cout << vas[i].size() << "\n";
    for (int j = 0; j < vas[i].size(); j++) {
      if (j > 0) {
        cout << " ";
      }
      cout << (vas[i][j] + 1);
    }
    cout << "\n";
  }
  cin >> n;
}
