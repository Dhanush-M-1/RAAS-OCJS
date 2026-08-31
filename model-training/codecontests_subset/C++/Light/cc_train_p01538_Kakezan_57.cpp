#include <iostream>
#include <algorithm>
#include <stdlib.h>
#include <string>
#include <queue>
#include <map>
#include <stack>
using namespace std;

int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};


int main() {
int r[8]={1,10,100,1000,10000,100000,1000000,10000000};

int q,n,ans;
cin>>q;
for(int z=0;z<q;z++){
ans=0;
cin>>n;
while(n>=10){
int m=0;
for(int i=1;i<7;i++){
if((n%(r[i]))*(n/(r[i]))>m) m=(n%(r[i]))*(n/(r[i]));

}
n=m;
ans++;


}
cout<<ans<<endl;

}

	return 0;
}