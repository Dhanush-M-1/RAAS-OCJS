#include <iostream> 
#include <sstream> 
#include <iomanip> 
#include <algorithm> 
#include <cmath> 
#include <string> 
#include <vector> 
#include <list> 
#include <queue> 
#include <stack> 
#include <set> 
#include <map> 
#include <bitset> 
#include <numeric> 
#include <climits> 
#include <cfloat> 
using namespace std; 

int dy[] = {0, 2, 1, 0, 0, -2, -1, 0, 0};
int dx[] = {0, 0, 0, 2, 1, 0, 0, -2, -1};

int main()
{
    for(;;){
        int n;
        cin >> n;
        if(n == 0)
            return 0;

        bool first = true;
        vector<vector<vector<bool> > > dp(3, vector<vector<bool> >(3, vector<bool>(7*7*7*7, false)));
        dp[1][1][7*7*7*7-1] = true;
        while(--n >= 0){
            vector<vector<vector<bool> > > nextDp(3, vector<vector<bool> >(3, vector<bool>(7*7*7*7, false)));
            vector<vector<int> > market(4, vector<int>(4));
            for(int i=0; i<4; ++i){
                for(int j=0; j<4; ++j){
                    cin >> market[i][j];
                }
            }

            for(int y0=0; y0<3; ++y0){
                for(int x0=0; x0<3; ++x0){
                    for(int a=0; a<7*7*7*7; ++a){
                        if(!dp[y0][x0][a])
                            continue;
                        vector<int> rest(4);
                        int tmp = a;
                        for(int i=0; i<4; ++i){
                            rest[i] = tmp % 7;
                            tmp /= 7;
                        }

                        for(int i=0; i<9; ++i){
                            if(first && i > 0)
                                break;

                            int y = y0 + dy[i];
                            int x = x0 + dx[i];
                            if(y < 0 || y > 2 || x < 0 || x > 2)
                                continue;
                            if(market[y][x] || market[y][x+1] || market[y+1][x] || market[y+1][x+1])
                                continue;

                            vector<int> nextRest = rest;
                            if(y == 0 && x == 0)
                                nextRest[0] = 7;
                            if(y == 0 && x == 2)
                                nextRest[1] = 7;
                            if(y == 2 && x == 0)
                                nextRest[2] = 7;
                            if(y == 2 && x == 2)
                                nextRest[3] = 7;
                            bool ng = false;
                            for(int i=0; i<4; ++i){
                                -- nextRest[i];
                                if(nextRest[i] < 0)
                                    ng = true;
                            }

                            if(!ng){
                                int b = 0;
                                for(int i=3; i>=0; --i){
                                    b *= 7;
                                    b += nextRest[i];
                                }
                                nextDp[y][x][b] = true;
                            }
                        }
                    }
                }
            }

            dp.swap(nextDp);
            first = false;
        }

        bool ret = false;
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                for(int k=0; k<7*7*7*7; ++k){
                    ret |= dp[i][j][k];
                }
            }
        }
        if(ret)
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }
}