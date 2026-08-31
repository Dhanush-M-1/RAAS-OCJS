#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
#define llint long long
#define inf 1e18

using namespace std;

llint n;
bool dp[405][3][3][7][7][7][7];
bool sch[405][4][4];
llint dx[] = {1, 0, -1, 0}, dy[] = {0, -1, 0, 1};

bool check(llint d, llint x, llint y)
{
	if(sch[d][x][y] || sch[d][x+1][y] || sch[d][x][y+1] || sch[d][x+1][y+1]) return false;
	return true;
}

int main(void)
{
	while(1){
		cin >> n;
		if(n == 0) break;
		
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < 16; j++){
				cin >> sch[i][j%4][j/4];
			}
		}
		
		for(int d = 0; d <= n; d++){
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					for(int i = 0; i < 7; i++){
						for(int j = 0; j < 7;j++){
							for(int k = 0; k < 7; k++){
								for(int l = 0; l < 7; l++){
									dp[d][x][y][i][j][k][l] = false;
								}
							}
						}
					}
				}
			}
		}
		if(!check(1, 1, 1)){
			cout << 0 << endl;
			continue;
		}
		dp[1][1][1][1][1][1][1] = true;
		
		for(int d = 1; d < n; d++){
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					for(int i = 0; i < 7; i++){
						for(int j = 0; j < 7;j++){
							for(int k = 0; k < 7; k++){
								for(int l = 0; l < 7; l++){
									if(!dp[d][x][y][i][j][k][l]) continue;
									for(int s = 0; s < 4; s++){
										for(int t = 0; t <= 2; t++){
											llint nx = x + t*dx[s], ny = y + t*dy[s];
											if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
											if(!check(d+1, nx, ny)) continue;
											llint ni = i+1, nj = j+1, nk = k+1, nl = l+1;
											if(nx == 0 && ny == 0) ni = 0;
											if(nx == 0 && ny == 2) nj = 0;
											if(nx == 2 && ny == 2) nk = 0;
											if(nx == 2 && ny == 0) nl = 0;
											if(ni >= 7 || nj >= 7 || nk >= 7 || nl >= 7) continue;
											dp[d+1][nx][ny][ni][nj][nk][nl] = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	
		bool ans = false;
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				for(int i = 0; i < 7; i++){
					for(int j = 0; j < 7;j++){
						for(int k = 0; k < 7; k++){
							for(int l = 0; l < 7; l++){
								ans |= dp[n][x][y][i][j][k][l];
							}
						}
					}
				}
			}
		}
		if(ans) cout << 1 << endl;
		else cout << 0 << endl;
	}

	return 0;
}
