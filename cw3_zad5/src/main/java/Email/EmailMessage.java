package Email;


import java.util.LinkedList;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    protected EmailMessage(String from, LinkedList<String> to, String subject, String content, String mimeType, LinkedList<String> cc, LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }

    public static class Builder{

        private String from;
        private LinkedList<String> to = new LinkedList();
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc = new LinkedList();;
        private LinkedList<String> bcc = new LinkedList();;

        public Builder addFrom(String _from){
            from = _from;
            return this;
        }
        public Builder addTo(String _to){
            to.add(_to);
            return this;
        }
        public Builder addSubject(String _subject){
            subject = _subject;
            return this;
        }
        public Builder addContent(String _content){
            content = _content;
            return this;
        }
        public Builder addMimeType(String _mimeType){
            mimeType = _mimeType;
            return this;
        }
        public Builder addCC(String _cc){
            cc.add(_cc);
            return this;
        }
        public Builder addBCC(String _bcc){
            bcc.add(_bcc);
            return this;
        }
        public EmailMessage build(){
            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
        }
    }
}

