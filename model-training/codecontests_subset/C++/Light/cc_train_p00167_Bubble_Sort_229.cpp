#include<cstdio>
#include<cstdlib>
#include<cmath>
#include<cstring>
#include<cctype>
#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#include<stack>
#include<queue>
#include<map>

using namespace std;
const int dx[] = {1,0,-1,0} , dy[] = {0,1,0,-1};
#define INF 999999
int main(){
    int n;
    while(scanf("%d",&n),n){
        int so[128]={0};
        for(int i = 0; i < n; i++)scanf("%d",&so[i]);

        int cnt = 0;
        for(int i = n-1; i > 0; i--){
            for(int j = 1; j <= i; j++){
                if(so[j] < so[j-1]){
                    swap(so[j],so[j-1]);
                    cnt++;
                }
            }
        }
        printf("%d\n",cnt);
    }
	return 0;
}