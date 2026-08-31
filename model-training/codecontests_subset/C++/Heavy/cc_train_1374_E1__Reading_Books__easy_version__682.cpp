#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << "\n";
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
inline long long sbt(long long x) { return __builtin_popcountll(x); }
inline long long iceil(double a) { return (long long)(ceil(a)); }
inline long long mul(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return ((a % m) * (b % m)) % m;
}
inline long long add(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return (a + b) % m;
}
inline long long sub(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return (a - b + m) % m;
}
long long fastpow(long long a, long long b,
                  long long m = (long long)(1e9 + 7)) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a, m);
    a = mul(a, a, m);
    b >>= 1;
  }
  return res;
}
long long modinv(long long a, long long m = (long long)(1e9 + 7)) {
  return fastpow(a, m - 2, m);
}
long long n, m, k;
vector<pair<long long, pair<long long, long long>>> v;
vector<pair<long long, long long>> both, alice, bob, none;
void get_ac() {
  cin >> n >> m >> k;
  long long a, b, c, ca = 0, cb = 0;
  for (auto i = 1; i <= n; i++) {
    cin >> a >> b >> c;
    if (b == 1 && c == 1) {
      both.push_back({a, i});
      ca++;
      cb++;
    } else if (b == 1) {
      alice.push_back({a, i});
      ca++;
    } else if (c == 1) {
      bob.push_back({a, i});
      cb++;
    } else {
      none.push_back({a, i});
    }
  }
  if (ca < k || cb < k) {
    cout << -1;
    return;
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(both.begin(), both.end());
  sort(none.begin(), none.end());
  long long inone, iboth = 0, ialice = 0, ibob = 0;
  long long nboth = (long long)(both.size()),
            nalice = (long long)(alice.size()), nbob = (long long)(bob.size()),
            nnone = (long long)(none.size());
  long long ans = 0, books = 0;
  set<long long> indices;
  long long kk = min({k, nalice, nbob});
  for (long i = 0; i < kk; i++) {
    ans += alice[i].first;
    books++;
    indices.insert(alice[i].second);
  }
  for (long i = 0; i < kk; i++) {
    ans += bob[i].first;
    books++;
    indices.insert(bob[i].second);
  }
  for (long i = 0; i < k - kk; i++) {
    ans += both[i].first;
    books++;
    indices.insert(both[i].second);
  }
  int i = kk - 1;
  iboth = k - kk;
  while (iboth < nboth && i >= 0 &&
         alice[i].first + bob[i].first > both[iboth].first) {
    ans -= alice[i].first + bob[i].first - both[iboth].first;
    indices.erase(alice[i].second);
    indices.erase(bob[i].second);
    indices.insert(both[iboth].second);
    i--;
    iboth++;
    books--;
  }
  if (books == m) {
    cout << ans;
    cout << "\n";
    assert((long long)(indices.size()) == m);
    for (auto i : indices) {
      cout << i << " ";
    }
    return;
  } else if (books > m) {
    while (books > m && iboth < nboth && i >= 0) {
      ans -= alice[i].first + bob[i].first - both[iboth].first;
      books--;
      indices.erase(alice[i].second);
      indices.erase(bob[i].second);
      indices.insert(both[iboth].second);
      i--;
      iboth++;
    }
    ialice = i, ibob = i;
    while (1) {
      if (ialice >= 0 && ibob >= 0 && iboth < nboth &&
          alice[ialice].first > both[iboth].first &&
          bob[ibob].first > both[iboth].first) {
        if (alice[ialice] > bob[ibob]) {
          ans -= bob[ibob].first - both[iboth].first;
          indices.erase(bob[ibob].second);
          indices.insert(both[iboth].second);
          ibob--;
          iboth++;
        } else {
          ans -= alice[ialice].first - both[iboth].first;
          indices.erase(alice[ialice].second);
          indices.insert(both[iboth].second);
          ialice--;
          iboth++;
        }
      } else if (ialice >= 0 && iboth < nboth &&
                 alice[ialice].first > both[iboth].first) {
        ans -= alice[ialice].first - both[iboth].first;
        indices.erase(alice[ialice].second);
        indices.insert(both[iboth].second);
        ialice--;
        iboth++;
      } else if (ibob >= 0 && iboth < nboth &&
                 bob[ibob].first > both[iboth].first) {
        ans -= bob[ibob].first - both[iboth].first;
        indices.erase(bob[ibob].second);
        indices.insert(both[iboth].second);
        ibob--;
        iboth++;
      } else {
        break;
      }
    }
    while (1) {
      if (iboth - 1 >= 0 && ialice + 1 < nalice && ibob + 1 < nbob &&
          alice[ialice + 1].first < both[iboth - 1].first &&
          bob[ibob + 1].first < both[iboth - 1].first) {
        if (alice[ialice + 1] < bob[ibob + 1]) {
          if (ibob + 1 + iboth - 1 >= k) {
            ans += alice[ialice + 1].first - both[iboth - 1].first;
            indices.insert(alice[ialice + 1].second);
            indices.erase(both[iboth - 1].second);
            ialice++;
            iboth--;
          } else if (ialice + 1 + iboth - 1 >= k) {
            ans += bob[ibob + 1].first - both[iboth - 1].first;
            indices.insert(bob[ibob + 1].second);
            indices.erase(both[iboth - 1].second);
            ibob++;
            iboth--;
          } else {
            break;
          }
        } else {
          if (ialice + 1 + iboth - 1 >= k) {
            ans += bob[ibob + 1].first - both[iboth - 1].first;
            indices.insert(bob[ibob + 1].second);
            indices.erase(both[iboth - 1].second);
            ibob++;
            iboth--;
          } else if (ibob + 1 + iboth - 1 >= k) {
            ans += alice[ialice + 1].first - both[iboth - 1].first;
            indices.insert(alice[ialice + 1].second);
            indices.erase(both[iboth - 1].second);
            ialice++;
            iboth--;
          } else {
            break;
          }
        }
      } else if (iboth - 1 >= 0 && ialice + 1 < nalice &&
                 alice[ialice + 1].first < both[iboth - 1].first &&
                 ibob + 1 + iboth - 1 >= k) {
        ans += alice[ialice + 1].first - both[iboth - 1].first;
        indices.insert(alice[ialice + 1].second);
        indices.erase(both[iboth - 1].second);
        ialice++;
        iboth--;
      } else if (iboth - 1 >= 0 && ibob + 1 < nbob &&
                 bob[ibob + 1].first < both[iboth - 1].first &&
                 ialice + 1 + iboth - 1 >= k) {
        ans += bob[ibob + 1].first - both[iboth - 1].first;
        indices.insert(bob[ibob + 1].second);
        indices.erase(both[iboth - 1].second);
        ibob++;
        iboth--;
      } else {
        break;
      }
    }
    if (books > m) {
      cout << -1;
    } else {
      cout << ans;
      cout << "\n";
      assert((long long)(indices.size()) == m);
      for (auto i : indices) {
        cout << i << " ";
      }
    }
    return;
  } else {
    ialice = i;
    ibob = i;
    inone = -1;
    iboth = iboth - 1;
    while (books < m) {
      vector<pair<pair<long long, long long>, long long>> candidates;
      bool f = 0;
      if (inone + 1 < (long long)(none.size())) {
        candidates.push_back({none[inone + 1], 0});
      }
      if (ialice + 1 < (long long)(alice.size())) {
        candidates.push_back({alice[ialice + 1], 1});
      }
      if (ibob + 1 < (long long)(bob.size())) {
        candidates.push_back({bob[ibob + 1], 2});
      }
      if (iboth + 1 < (long long)(both.size())) {
        candidates.push_back({both[iboth + 1], 3});
      }
      if ((long long)(candidates.size()) == 0) break;
      sort(candidates.begin(), candidates.end());
      if (ibob + 1 < (long long)(bob.size()) &&
          ialice + 1 < (long long)(alice.size()) && iboth >= 0) {
        long long cur =
            bob[ibob + 1].first + alice[ialice + 1].first - both[iboth].first;
        if (cur > candidates[0].first.first) {
        } else {
          f = 1;
          ans += cur;
          indices.insert(bob[ibob + 1].second);
          indices.insert(alice[ialice + 1].second);
          indices.erase(both[iboth].second);
          ialice++;
          ibob++;
          iboth--;
        }
      }
      if (!f) {
        pair<long long, long long> p = candidates[0].first;
        long long q = candidates[0].second;
        ans += p.first;
        indices.insert(p.second);
        if (q == 0) {
          inone++;
        } else if (q == 1) {
          ialice++;
        } else if (q == 2) {
          ibob++;
        } else {
          iboth++;
        }
      }
      books++;
    }
    assert((long long)(indices.size()) == m);
    iboth++;
    while (1) {
      if (ialice >= 0 && ibob >= 0 && iboth < nboth &&
          alice[ialice].first > both[iboth].first &&
          bob[ibob].first > both[iboth].first) {
        if (alice[ialice] > bob[ibob]) {
          ans -= bob[ibob].first - both[iboth].first;
          indices.erase(bob[ibob].second);
          indices.insert(both[iboth].second);
          ibob--;
          iboth++;
        } else {
          ans -= alice[ialice].first - both[iboth].first;
          indices.erase(alice[ialice].second);
          indices.insert(both[iboth].second);
          ialice--;
          iboth++;
        }
      } else if (ialice >= 0 && iboth < nboth &&
                 alice[ialice].first > both[iboth].first) {
        ans -= alice[ialice].first - both[iboth].first;
        indices.erase(alice[ialice].second);
        indices.insert(both[iboth].second);
        ialice--;
        iboth++;
      } else if (ibob >= 0 && iboth < nboth &&
                 bob[ibob].first > both[iboth].first) {
        ans -= bob[ibob].first - both[iboth].first;
        indices.erase(bob[ibob].second);
        indices.insert(both[iboth].second);
        ibob--;
        iboth++;
      } else {
        break;
      }
    }
    assert((long long)(indices.size()) == m);
    while (1) {
      if (iboth - 1 >= 0 && ialice + 1 < nalice && ibob + 1 < nbob &&
          alice[ialice + 1].first < both[iboth - 1].first &&
          bob[ibob + 1].first < both[iboth - 1].first) {
        if (alice[ialice + 1] < bob[ibob + 1]) {
          if (ibob + 1 + iboth - 1 >= k) {
            ans += alice[ialice + 1].first - both[iboth - 1].first;
            indices.insert(alice[ialice + 1].second);
            indices.erase(both[iboth - 1].second);
            ialice++;
            iboth--;
          } else if (ialice + 1 + iboth - 1 >= k) {
            ans += bob[ibob + 1].first - both[iboth - 1].first;
            indices.insert(bob[ibob + 1].second);
            indices.erase(both[iboth - 1].second);
            ibob++;
            iboth--;
          } else {
            break;
          }
        } else {
          if (ialice + 1 + iboth - 1 >= k) {
            ans += bob[ibob + 1].first - both[iboth - 1].first;
            indices.insert(bob[ibob + 1].second);
            indices.erase(both[iboth - 1].second);
            ibob++;
            iboth--;
          } else if (ibob + 1 + iboth - 1 >= k) {
            ans += alice[ialice + 1].first - both[iboth - 1].first;
            indices.insert(alice[ialice + 1].second);
            indices.erase(both[iboth - 1].second);
            ialice++;
            iboth--;
          } else {
            break;
          }
        }
      } else if (iboth - 1 >= 0 && ialice + 1 < nalice &&
                 alice[ialice + 1].first < both[iboth - 1].first &&
                 ibob + 1 + iboth - 1 >= k) {
        ans += alice[ialice + 1].first - both[iboth - 1].first;
        indices.insert(alice[ialice + 1].second);
        indices.erase(both[iboth - 1].second);
        ialice++;
        iboth--;
      } else if (iboth - 1 >= 0 && ibob + 1 < nbob &&
                 bob[ibob + 1].first < both[iboth - 1].first &&
                 ialice + 1 + iboth - 1 >= k) {
        ans += bob[ibob + 1].first - both[iboth - 1].first;
        indices.insert(bob[ibob + 1].second);
        indices.erase(both[iboth - 1].second);
        ibob++;
        iboth--;
      } else {
        break;
      }
    }
    assert((long long)(indices.size()) == m);
    while (1) {
      vector<pair<long long, long long>> candidates;
      if (inone + 1 < nnone && ialice >= 0 && (ialice + 1 + iboth) > k &&
          none[inone + 1].first < alice[ialice].first) {
        candidates.push_back({none[inone + 1].first - alice[ialice].first, 0});
      }
      if (inone + 1 < nnone && ibob >= 0 && (ibob + 1 + iboth) > k &&
          none[inone + 1].first < bob[ibob].first) {
        candidates.push_back({none[inone + 1].first - bob[ibob].first, 1});
      }
      if ((long long)(candidates.size()) == 0) break;
      sort(candidates.begin(), candidates.end());
      if ((long long)(candidates.size()) == 2 && iboth - 1 >= 0 &&
          none[inone + 1].first - both[iboth - 1].first < candidates[0].first) {
        long long curcandidate = none[inone + 1].first - both[iboth - 1].first;
        ans += curcandidate;
        indices.erase(both[iboth - 1].second);
        indices.insert(none[inone + 1].second);
        iboth--;
        inone++;
      } else {
        if (candidates[0].first == 0) {
          ans += candidates[0].first;
          indices.erase(alice[ialice].second);
          indices.insert(none[inone + 1].second);
          ialice--;
          inone++;
        } else {
          ans += candidates[0].first;
          indices.erase(bob[ibob].second);
          indices.insert(none[inone + 1].second);
          ibob--;
          inone++;
        }
      }
    }
    if (books < m) {
      cout << -1;
    } else {
      cout << ans;
      cout << "\n";
      assert((long long)(indices.size()) == m);
      for (auto i : indices) {
        cout << i << " ";
      }
    }
    return;
  }
}
int main() {
  cin.sync_with_stdio(false);
  cout.sync_with_stdio(false);
  cin.tie(NULL);
  {
    get_ac();
    cout << "\n";
  }
  return 0;
}
