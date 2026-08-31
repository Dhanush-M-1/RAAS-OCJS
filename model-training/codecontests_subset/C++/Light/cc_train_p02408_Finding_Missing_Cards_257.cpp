#include <iostream>
#include <string>
using namespace std;
int main(){
    int n, rank;
    bool card[4][13];
    char c;
    string suits="SHCD";
 
    for (int i=0; i<4; i++)
        for (int j=0; j<13; ++j) 
            card[i][j] = true;
    
    cin >> n;
    for (int i=0; i<n; i++){
        cin>>c>>rank;
        card[suits.find(c)][rank-1] = false;
    }
 
    for(int i=0;i<4;i++)
      for(int j=0;j<13;j++) 
            if(card[i][j]==true) cout<<suits.at(i)<<" "<<j+1<<endl;
}