#include <bits/stdc++.h>
using namespace std;
const long long _siz6xTU51_skxxXnGl2_sgUZxRBhyMOD = 1000000007;
const long long _siz6xTU51_skxxXnGl2_sgUZxRBhyN = 100000;
template <typename _siz6xTU51_skxxXnGl2_sgUZxRBhythird>
ostream& operator<<(ostream& _siz6xTU51_skxxXnGl2_sgUZxRBhyos,
                    const vector<_siz6xTU51_skxxXnGl2_sgUZxRBhythird>&
                        _siz6xTU51_skxxXnGl2_sgUZxRBhyv) {
  _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x7b";
  for (auto _siz6xTU51_skxxXnGl2_sgUZxRBhyit =
           _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin();
       _siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
       _siz6xTU51_skxxXnGl2_sgUZxRBhyv.end();
       ++_siz6xTU51_skxxXnGl2_sgUZxRBhyit) {
    if (_siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
        _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin())
      _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x2c\x20";
    _siz6xTU51_skxxXnGl2_sgUZxRBhyos << *_siz6xTU51_skxxXnGl2_sgUZxRBhyit;
  }
  return _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x7d";
}
template <typename first, typename second>
ostream& operator<<(
    ostream& _siz6xTU51_skxxXnGl2_sgUZxRBhyos,
    const pair<first, second>& _siz6xTU51_skxxXnGl2_sgUZxRBhyp) {
  return _siz6xTU51_skxxXnGl2_sgUZxRBhyos
         << "\x28" << _siz6xTU51_skxxXnGl2_sgUZxRBhyp.first << "\x2c\x20"
         << _siz6xTU51_skxxXnGl2_sgUZxRBhyp.second << "\x29";
}
template <typename _siz6xTU51_skxxXnGl2_sgUZxRBhythird>
ostream& operator<<(ostream& _siz6xTU51_skxxXnGl2_sgUZxRBhyos,
                    const set<_siz6xTU51_skxxXnGl2_sgUZxRBhythird>&
                        _siz6xTU51_skxxXnGl2_sgUZxRBhyv) {
  _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5b";
  for (auto _siz6xTU51_skxxXnGl2_sgUZxRBhyit =
           _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin();
       _siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
       _siz6xTU51_skxxXnGl2_sgUZxRBhyv.end();
       ++_siz6xTU51_skxxXnGl2_sgUZxRBhyit) {
    if (_siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
        _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin())
      _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x2c\x20";
    _siz6xTU51_skxxXnGl2_sgUZxRBhyos << *_siz6xTU51_skxxXnGl2_sgUZxRBhyit;
  }
  return _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5d";
}
template <typename _siz6xTU51_skxxXnGl2_sgUZxRBhythird>
ostream& operator<<(ostream& _siz6xTU51_skxxXnGl2_sgUZxRBhyos,
                    const multiset<_siz6xTU51_skxxXnGl2_sgUZxRBhythird>&
                        _siz6xTU51_skxxXnGl2_sgUZxRBhyv) {
  _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5b";
  for (auto _siz6xTU51_skxxXnGl2_sgUZxRBhyit =
           _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin();
       _siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
       _siz6xTU51_skxxXnGl2_sgUZxRBhyv.end();
       ++_siz6xTU51_skxxXnGl2_sgUZxRBhyit) {
    if (_siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
        _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin())
      _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x2c\x20";
    _siz6xTU51_skxxXnGl2_sgUZxRBhyos << *_siz6xTU51_skxxXnGl2_sgUZxRBhyit;
  }
  return _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5d";
}
template <typename first, typename second>
ostream& operator<<(ostream& _siz6xTU51_skxxXnGl2_sgUZxRBhyos,
                    const map<first, second>& _siz6xTU51_skxxXnGl2_sgUZxRBhyv) {
  _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5b";
  for (auto _siz6xTU51_skxxXnGl2_sgUZxRBhyit =
           _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin();
       _siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
       _siz6xTU51_skxxXnGl2_sgUZxRBhyv.end();
       ++_siz6xTU51_skxxXnGl2_sgUZxRBhyit) {
    if (_siz6xTU51_skxxXnGl2_sgUZxRBhyit !=
        _siz6xTU51_skxxXnGl2_sgUZxRBhyv.begin())
      _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x2c\x20";
    _siz6xTU51_skxxXnGl2_sgUZxRBhyos
        << _siz6xTU51_skxxXnGl2_sgUZxRBhyit->first << "\x20\x3d\x20"
        << _siz6xTU51_skxxXnGl2_sgUZxRBhyit->second;
  }
  return _siz6xTU51_skxxXnGl2_sgUZxRBhyos << "\x5d";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  if (1) {
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhykk = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk <= 1000;
         _siz6xTU51_skxxXnGl2_sgUZxRBhykk++) {
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhypp = 34;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhyup = 20;
      long long _siz6xTU51_skxxXnGl2_sgUZxRBhycp = 13 * 23;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
      _siz6xTU51_skxxXnGl2_sgUZxRBhypp =
          _siz6xTU51_skxxXnGl2_sgUZxRBhyup + _siz6xTU51_skxxXnGl2_sgUZxRBhycp;
    }
  }
  long long _siz6xTU51_skxxXnGl2_sgUZxRBhytest;
  cin >> _siz6xTU51_skxxXnGl2_sgUZxRBhytest;
  while (_siz6xTU51_skxxXnGl2_sgUZxRBhytest--) {
    long long _siz6xTU51_skxxXnGl2_sgUZxRBhyn;
    cin >> _siz6xTU51_skxxXnGl2_sgUZxRBhyn;
    long long _siz6xTU51_skxxXnGl2_sgUZxRBhym;
    cin >> _siz6xTU51_skxxXnGl2_sgUZxRBhym;
    vector<long long> _siz6xTU51_skxxXnGl2_sgUZxRBhya(
        _siz6xTU51_skxxXnGl2_sgUZxRBhyn);
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhyi = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi < _siz6xTU51_skxxXnGl2_sgUZxRBhyn;
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi++) {
      cin >> _siz6xTU51_skxxXnGl2_sgUZxRBhya[_siz6xTU51_skxxXnGl2_sgUZxRBhyi];
    }
    vector<long long> _siz6xTU51_skxxXnGl2_sgUZxRBhyb(
        _siz6xTU51_skxxXnGl2_sgUZxRBhym);
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhyi = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi < _siz6xTU51_skxxXnGl2_sgUZxRBhym;
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi++) {
      cin >> _siz6xTU51_skxxXnGl2_sgUZxRBhyb[_siz6xTU51_skxxXnGl2_sgUZxRBhyi];
    }
    long long _siz6xTU51_skxxXnGl2_sgUZxRBhyres = -1e9;
    for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhyi = 0;
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi <
         _siz6xTU51_skxxXnGl2_sgUZxRBhya.size();
         _siz6xTU51_skxxXnGl2_sgUZxRBhyi++) {
      for (long long _siz6xTU51_skxxXnGl2_sgUZxRBhyj = 0;
           _siz6xTU51_skxxXnGl2_sgUZxRBhyj <
           _siz6xTU51_skxxXnGl2_sgUZxRBhyb.size();
           _siz6xTU51_skxxXnGl2_sgUZxRBhyj++) {
        if (_siz6xTU51_skxxXnGl2_sgUZxRBhya[_siz6xTU51_skxxXnGl2_sgUZxRBhyi] ==
            _siz6xTU51_skxxXnGl2_sgUZxRBhyb[_siz6xTU51_skxxXnGl2_sgUZxRBhyj]) {
          _siz6xTU51_skxxXnGl2_sgUZxRBhyres =
              _siz6xTU51_skxxXnGl2_sgUZxRBhyb[_siz6xTU51_skxxXnGl2_sgUZxRBhyj];
          break;
        }
      }
      if (_siz6xTU51_skxxXnGl2_sgUZxRBhyres != -1e9) {
        break;
      }
    }
    if (_siz6xTU51_skxxXnGl2_sgUZxRBhyres != -1e9) {
      cout << "\x59\x45\x53" << '\n';
      cout << 1 << "\x20" << _siz6xTU51_skxxXnGl2_sgUZxRBhyres << '\n';
    } else {
      cout << "\x4e\x4f" << '\n';
    }
  }
  return 0;
}
