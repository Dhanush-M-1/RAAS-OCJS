#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

class range {
private:
  struct Iterator {
    int val;
    int operator*() {return val;}
    bool operator!=(Iterator &itr) {return val < itr.val;}
    void operator++() {++val;}
  };
  Iterator i, n;
public:
  range(int n) : i({0}), n({n}) {}
  range(int i, int n) : i({i}), n({n}) {}
  Iterator &begin() {return i;}
  Iterator &end() {return n;}
};

template<class T> T at(vector<T> v, int i) {return v[(i % (int)v.size() + v.size()) % v.size()];}
const long long MOD = 10000;

class Inverse {
private:
	vector<long long> inv;
  
public:
	Inverse(int n) {
    inv = vector<long long>(n, 1);
		for (int i : range(2, n)) inv[i] = inv[MOD % i] * (MOD - MOD / i) % MOD;
  }
  
	long long operator()(long long a) const {
		if (a < (int)inv.size()) return inv[a];
		long long b = MOD, x = 1, y = 0;
		while (b) {
			long long t = a / b;
			swap(a -= t * b, b);
			swap(x -= t * y, y);
		}
		return (MOD + x % MOD) % MOD;
	}
};

Inverse inv(1000000);

class Mint {
private:
  long long val;
	
public:
	Mint() {}
	Mint(long long val) : val(val % MOD) {}
	
	Mint operator+=(const Mint &m) {
		val += m.val;
		if (val >= MOD) val -= MOD;
		return *this;
	}
  
	Mint operator-=(const Mint &m) {
		val -= m.val;
		if (val < 0) val += MOD;
		return *this;
	}
  
	Mint operator*=(const Mint &m) {
		val *= m.val;
		val %= MOD;
		return *this;
	}
  
	Mint operator/=(const Mint &m) {
		val *= inv(m.val);
		val %= MOD;
		return *this;
	}
	
	Mint operator+(const Mint &m) const {
		Mint res = *this;
		res += m;
		return res;
	}
	
	Mint operator-(const Mint &m) const {
		Mint res = *this;
		res -= m;
		return res;
	}
	
	Mint operator*(const Mint &m) const {
		Mint res = *this;
		res *= m;
		return res;
	}
	
	Mint operator/(const Mint &m) const {
		Mint res = *this;
		res /= m;
		return res;
	}
	
	Mint operator++() {return val += 1;}
  
	Mint operator--() {return val -= 1;}
  
  Mint operator=(int n) {return *this = Mint(n);}
	
	operator long long() {
		return val;
	}
};

ostream &operator<<(ostream &os, Mint a) {
	os << (long long)a;
	return os;
}

istream &operator>>(istream &is, Mint &a) {
	long long n;
	is >> n;
	a = Mint(n);
	return is;
}

#include <sstream>

template<class A, class B> B convert(A a) {
  stringstream ss;
  ss << a;
  B b;
  ss >> b;
  return b;
}

bool iszigzag(int a, int m) {
  if (a % m) return false;
  string s = convert<int, string>(a);
  for (int i : range(s.size() - 1)) {
    if (i % 2 == 0 && s[i] <= s[i + 1]) return false;
    if (i % 2 == 1 && s[i] >= s[i + 1]) return false;
  }
  return true;
}

bool iszagzig(int a, int m) {
  if (a % m) return false;
  string s = convert<int, string>(a);
  for (int i : range(s.size() - 1)) {
    if (i % 2 == 1 && s[i] <= s[i + 1]) return false;
    if (i % 2 == 0 && s[i] >= s[i + 1]) return false;
  }
  return true;
}

Mint solve(string s, Mint m) {
  if (s == "0") return 0;
  Mint res = 0;
  for (int t : range(2)) {
    vector<vector<vector<Mint>>> dp(2, vector<vector<Mint>>(11, vector<Mint>(m, 0)));
    for (int i : range(1, s[0] - '0')) dp[0][i][i % m] = 1;
    dp[0][10][int(s[0] - '0') % m] = 1;
    for (int i : range(1, s.size())) {
      if (i % 2 == t) {
        for (int mm : range(m)) for (int j : range(10)) for (int k : range(j)) dp[1][j][(mm * 10 + j) % m] += dp[0][k][mm];
        for (int mm : range(m)) for (int j : range(s[i] - '0')) if (j > s[i - 1] - '0') dp[1][j][(mm * 10 + j) % m] += dp[0][10][mm];
        if (s[i - 1] < s[i]) for (int mm : range(m)) dp[1][10][(mm * 10 + s[i] - '0') % m] += dp[0][10][mm];
        for (int j : range(1, 10)) ++dp[1][j][j % m];
      } else {
        for (int mm : range(m)) for (int j : range(10)) for (int k : range(j + 1, 10)) dp[1][j][(mm * 10 + j) % m] += dp[0][k][mm];
        for (int mm : range(m)) for (int j : range(s[i] - '0')) if (j < s[i - 1] - '0') dp[1][j][(mm * 10 + j) % m] += dp[0][10][mm];
        if (s[i - 1] > s[i]) for (int mm : range(m)) dp[1][10][(mm * 10 + s[i] - '0') % m] += dp[0][10][mm];
        for (int j : range(1, 10)) ++dp[1][j][j % m];
      }
      dp[0] = dp[1];
      for (auto &i : dp[1]) fill(i.begin(), i.end(), 0);
    }
    for (const auto &i : dp[0]) res += i[0];
  }
  if (s.size() == 1u) {
    for (int i : range(1, convert<string, int>(s))) if (i % m == 0) --res;
  } else {
    for (int i : range(1, 10)) if (i % m == 0) --res;
  }
  return res;
}

int main() {
  string a, b;
  Mint m;
  cin >> a >> b >> m;
  for (int i = a.size() - 1; i >= 0; --i) {
    if (a[i] != '0') {
      --a[i];
      break;
    } else {
      a[i] = '9';
    }
  }
  while (a.size() > 1u && a[0] == '0') a = a.substr(1);
  cout << solve(b, m) - solve(a, m) << endl;
}