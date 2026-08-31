#include "bits/stdc++.h"
#include<unordered_map>
#include<unordered_set>
#pragma warning(disable:4996)
using namespace std;
using ld = long double;
template<class T>
using Table = vector<vector<T>>;

const int dx[4] = { -1,0,1,0 };
const int dy[4] = { 0,1,0,-1 };
const int dx2[4] = { 0,0,1,1 };
const int dy2[4] = { 0,1,1,0 };

struct field {
	vector<vector<int>>drys;
	int cy;
	int cx;
	long long int hash;
	field(vector<vector<int>>drys_, const int cy_, const int cx_) :drys(drys_), cy(cy_), cx(cx_),hash(0) {
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				hash = hash * 10 + drys[i][j];
			}
		}
		hash = hash * 10 + cy;
		hash = hash * 10 + cx;
	}
	
};
bool operator<(const field&l, const field&r) {
	return l.hash < r.hash;
}

int main() {
	while (1) {
		int N; cin >> N;
		if (!N)break;
		vector<vector<vector<int>>>fests(N, vector<vector<int>>(4, vector<int>(4)));
		for (int day = 0; day < N; ++day) {
			for (int y = 0; y < 4; ++y) {
				for (int x = 0; x < 4; ++x) {
					int a; cin >> a;
					fests[day][y][x] = a;
				}
			}
		}
		set<field,less<field>,allocator<field>>fields;
		fields.emplace(field(vector<vector<int>>(4, vector<int>(4)), 1, 1));
		for (int day = 0; day < N; ++day) {
			set<field>nextfields;
			for (const auto f : fields) {
				const int nowcx = f.cx;
				const int nowcy = f.cy;
				if (day) {
					for (int cway = 0; cway <4; ++cway) {
						for (int dis = 1; dis <= 2; ++dis) {
							vector<vector<int>>nowdrys(f.drys);
							for (int y = 0; y < 4; ++y) {
								for (int x = 0; x < 4; ++x) {
									nowdrys[y][x]++;
								}
							}
							const int nexcx = nowcx + dx[cway] * dis;
							const int nexcy = nowcy + dy[cway] * dis;
							if (nexcx < 0 || nexcx >= 3 || nexcy < 0 || nexcy >= 3)continue;
							bool ok = true;
							for (int rainway = 0; rainway < 4; ++rainway) {
								const int rainy = nexcy + dy2[rainway];
								const int rainx = nexcx + dx2[rainway];
								if (fests[day][rainy][rainx])ok = false;
								nowdrys[rainy][rainx] = 0;
							}
							for (int y = 0; y < 4; ++y) {
								for (int x = 0; x < 4; ++x) {
									if (nowdrys[y][x] >= 7)ok = false;
								}
							}
							if (ok) {
								nextfields.emplace(nowdrys, nexcy, nexcx);
							}
						}
					}
				}
				{
					const int nexcx = nowcx;
					const int nexcy = nowcy;
					vector<vector<int>>nowdrys(f.drys);
					for (int y = 0; y < 4; ++y) {
						for (int x = 0; x < 4; ++x) {
							nowdrys[y][x]++;
						}
					}
					if (nexcx < 0 || nexcx>3 || nexcy < 0 || nexcy>3)continue;
					bool ok = true;
					for (int rainway = 0; rainway < 4; ++rainway) {
						const int rainy = nexcy + dy2[rainway];
						const int rainx = nexcx + dx2[rainway];
						if (fests[day][rainy][rainx])ok = false;
						nowdrys[rainy][rainx] = 0;
					}
					for (int y = 0; y < 4; ++y) {
						for (int x = 0; x < 4; ++x) {
							if (nowdrys[y][x] >= 7)ok = false;
						}
					}
					if (ok) {
						nextfields.emplace(nowdrys, nexcy, nexcx);
					}
				}
				
			}
			fields = nextfields;
			
		}
		if (!fields.empty())cout << 1 << endl;
		else cout << 0 << endl;
	}
	
	return 0;
}