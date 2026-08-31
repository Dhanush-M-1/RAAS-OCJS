#include <iostream>
#include <cmath>
#define state(a, b, c, d) (a * 7*7*7 + b * 7*7 + c * 7 + d)

using namespace std;

int N;
const int ST = state(6, 6, 6, 6) + 1;
int sche[370][16];
bool dp[370][ST][3][3];

int main(void)
{
	while(1){
		cin >> N;
		if(N == 0) break;
		
		for(int i = 1; i <= N; i++){
			for(int j = 0; j < 16; j++){
				cin >> sche[i][j];
			}
		}
		
		if(sche[1][5] || sche[1][6] || sche[1][9] || sche[1][10]){
			cout << "0" << endl;
			continue;
		}
		
		for(int i = 1; i <= N; i++){
			for(int j = 0; j < ST; j++){
				for(int x = 0; x < 3; x++){
					for(int y = 0; y < 3; y++){
						dp[i][j][x][y] = false;
					}
				}
			}
		}
		dp[1][state(1, 1, 1, 1)][1][1] = true;
		
		int pos;
		int st, sa, sb, sc, sd;
		
		for(int i = 1; i < N; i++){
			for(int j = 0; j < ST; j++){
				for(int x = 0; x < 3; x++){
					for(int y = 0; y < 3; y++){
						if(dp[i][j][x][y] == false) continue;
						for(int nx = 0; nx < 3; nx++){
							for(int ny = 0; ny < 3; ny++){
								if( abs(nx-x)+abs(ny-y) > 2 || (nx-x)*(ny-y)) continue;
								pos = ny*4 + nx;
								if(sche[i+1][pos] || sche[i+1][pos+1] || sche[i+1][pos+4] || sche[i+1][pos+5]) continue;
								st = j;
								sd = st % 7, st /= 7;
								sc = st % 7, st /= 7;
								sb = st % 7, st /= 7;
								sa = st % 7;
								sa++, sb++, sc++, sd++;
								if(pos == 0) sa = 0;
								if(pos == 2) sb = 0;
								if(pos == 8) sc = 0;
								if(pos == 10) sd = 0;
								if(sa > 6 || sb > 6 || sc > 6 || sd > 6) continue;
								dp[i+1][state(sa, sb, sc, sd)][nx][ny] = true;
								
							}
						}
					}
				}
			}
		}
		
		int flag = false;
		for(int i = 0; i < ST; i++){
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					if(dp[N][i][x][y]){
						flag = true;
						goto end;
					}
				}
			}
		}
		end:;
		if(flag) cout << "1" << endl;
		else cout << "0" << endl;
	}
	
	return 0;
}