#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <list>
#include <queue>
#include <stack>
#include <set>
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <cstring>
#include <climits>

#define LP(i,n) for(int i=0;i<n;i++)
#define Mset(x,v) memset(x,v,sizeof(x))
#define INF INT_MAX

using namespace std;
using LL=long long;

int I[1005];

int main(){
    int n;
    cin>>n;
    LP(i,n) cin>>I[i];
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(abs(I[i]-I[j])%(n-1)==0){
                cout<<I[i]<<" "<<I[j]<<endl;
                return 0;
            }
        }
    }
    return 0;
}

