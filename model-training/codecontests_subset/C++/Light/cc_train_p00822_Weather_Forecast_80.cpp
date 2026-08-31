#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef tuple<int, int, int, ll> T;

int N;
int fst[400];
int dx[9] = {0, 0, 1, 0, -1, 0, 2, 0, -2};
int dy[9] = {0, -1, 0, 1, 0, -2, 0, 2, 0};
set<T> memo;

bool rain(int px, int py,  int idx){
	int cloud = px + py * 4;
	return cloud == idx || cloud + 1 == idx || cloud + 4 == idx || cloud + 5 == idx;
}

bool dfs(int day, int px, int py,  ll state){
	//printf("Day %d (%d %d)\n", day, px, py);

	if(day >= N) return true;
	if(memo.count(T(day, px, py, state))) return false;
	memo.insert(T(day, px, py, state));
	int rainy = 0;
	for(int y = 0; y < 4; y++){
		for(int x = 0; x < 4; x++){
			ll idx = x + y * 4;
			ll cnt = (state >> (idx * 3LL)) & 7LL;
			if(rain(px, py, idx)) {
				cnt = 0;
				rainy |= (1 << idx);
			}else{
				cnt++;
			}

			if(cnt >= 7) return false;
			state = (state & ~(7LL << (idx * 3LL))) | (cnt << (idx * 3LL));
		}
	}
	if((fst[day] & rainy)) return false;
	for(int i = 0; i < 9; i++){
		int nx = px + dx[i];
		int ny = py + dy[i];
		if(0 <= nx && nx <= 2 && 0 <= ny && ny <= 2){
			if(dfs(day + 1, nx, ny, state)) return true;
		}
	}
	return false;
}

int main(){
	while(cin >> N, N){
		for(int i = 0; i < N; i++){
			fst[i] = 0;
			for(int j = 0; j < 16; j++){
				int v;
				cin >> v;
				fst[i] |= (v << j); 
			}
		}
		memo.clear();
		if(dfs(0, 1, 1, 0)){
			cout << 1 << endl;
		}else{
			cout << 0 << endl;
		}
	}
}