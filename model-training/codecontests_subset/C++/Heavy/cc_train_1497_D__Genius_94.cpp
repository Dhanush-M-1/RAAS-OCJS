//也请让我相信，你一直以来所相信的事吧——“活着是一件很美好的事”
//只要记住你的名字，不管你在世界的哪个地方，我一定会去见你!
//我现在依然喜欢着你，但我们就算是来往一千封邮件，心却不可能接近哪怕一厘米。
//嗯，那样的话，你就再努力一次试试吧！别在这种地方畏畏缩缩的！别对自己说谎！再努力一次吧。
//我说过了，若是有想要拯救之物，就果断地出手全力去守护!
//拜托了，请把力量借给软弱的我，给我从这里再度起身迈步的力量！
//虽然灯塔已经失去了光明……但是，只要有你的那首歌在，就一定能将那些人再次导向此方。
//小时候曾认为这个世界单纯简单，没有赢不了的比试，努力就会有回报，认为这世上一切皆有可能。
//虽然我能办到的或许只有陪伴你……但是，至少我可以陪着你。
//如果声音有形状的话，那一定是你喜欢的样子。
#include<bits/stdc++.h>
using namespace std;
#define int long long
#define fastio ios::sync_with_stdio(0);cin.tie(0);cout.tie(0)
void solve() {
    int n; cin >> n;
    vector<int>dp(n + 1), tag(n + 1), s(n + 1);
    for(int i=1;i<=n;i++) {
        cin >> tag[i];
    }
    for(int i=1;i<=n;i++) {
        cin >> s[i];
    }
    for(int i=2;i<=n;i++) {
        for(int j=i-1;j>=1;j--) {
            if(tag[i] == tag[j]) continue;
            int tmpi = max(dp[i], dp[j] + abs(s[i] - s[j]));
            int tmpj = max(dp[j], dp[i] + abs(s[i] - s[j]));
            dp[i] = tmpi;
            dp[j] = tmpj;
        }
    } 
    int ans = 0;
    for(int i=1;i<=n;i++) {
        ans = max(ans, dp[i]);
    }
    cout << ans << '\n';
}
signed main() {
    //fastio;
    int t = 1;
    cin >> t;
    while(t--) solve();
    return 0;
}